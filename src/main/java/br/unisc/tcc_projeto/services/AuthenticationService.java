package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.DTO.AuthResponse;
import br.unisc.tcc_projeto.DTO.LoginRequest;
import br.unisc.tcc_projeto.DTO.RegisterRequest;
import br.unisc.tcc_projeto.entidades.Usuario;
import br.unisc.tcc_projeto.repositories.UsuarioRepository;
import br.unisc.tcc_projeto.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public Usuario findUserByLogin(String login) {
        return usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
    }

    // Método para autenticar o usuário no login
    public AuthResponse authenticateUser(LoginRequest loginRequest) throws Exception {
        // Busca o usuário no banco de dados
        Usuario usuario = usuarioRepository.findByEmailOrCpfOrTelefone(
                loginRequest.getLogin(),
                loginRequest.getLogin(),
                loginRequest.getLogin()
        ).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        // Valida a senha
        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
            throw new BadCredentialsException("Senha inválida!");
        }

        String token = JwtUtil.generateJwtToken(usuario);

        return new AuthResponse(token, usuario.getTipoDeUsuario(), usuario.getNome());
    }

    public String register(RegisterRequest request) {
        // Verifica se e-mail, CPF ou telefone já estão cadastrados
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado!");
        }
        if (usuarioRepository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        if (usuarioRepository.existsByTelefone(request.getTelefone())) {
            throw new IllegalArgumentException("Telefone já cadastrado!");
        }

        // Cria e popula o novo usuário como CLIENTE
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setCpf(request.getCpf());
        usuario.setTelefone(request.getTelefone());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setTipoDeUsuario(request.getTipoDeUsuario());
//      usuario.setTipoDeUsuario("USUARIO"); // Define como CLIENTE automaticamente

        // Salva no banco de dados
        usuarioRepository.save(usuario);

        // Garante que o tipo de usuário esteja preenchido
        if (request.getTipoDeUsuario() == null || request.getTipoDeUsuario().isEmpty()) {
        } else {
            usuario.setTipoDeUsuario(request.getTipoDeUsuario());
        }

        return "Cadastro realizado com sucesso!";
    }


    // Método para verificar se o usuário é CLIENTE
    public boolean isClient(String login) {
        // Busca o usuário pelo login (e-mail, CPF ou telefone)
        Usuario usuario = usuarioRepository.findByEmailOrCpfOrTelefone(login, login, login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        // Retorna true se o tipo do usuário for CLIENTE
        return "CLIENTE".equals(usuario.getTipoDeUsuario());
    }



}

