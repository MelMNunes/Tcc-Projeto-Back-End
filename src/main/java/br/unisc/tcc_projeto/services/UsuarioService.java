package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.entidades.Usuario;
import br.unisc.tcc_projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorEmailCpfOuTelefone(String login) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailOrCpfOrTelefone(login, login, login);
        return usuario.orElse(null); // Retorna o usuário ou null caso não encontrado
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public boolean usuarioExiste(String login) {
        return usuarioRepository.findByEmailOrCpfOrTelefone(login, login, login).isPresent();
    }


    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarFuncionarios() {
        return usuarioRepository.findByTipoDeUsuario("FUNCIONARIO");
    }

    public List<Usuario> listarAdministradores() {
        return usuarioRepository.findByTipoDeUsuario("ADMINISTRADOR");
    }

    public List<Usuario> listarClientes() {
        return usuarioRepository.findByTipoDeUsuario("CLIENTE");
    }

    public List<Usuario> listarUsuarioPorTipo(String tipoDeUsuario) {
        return usuarioRepository.findByTipoDeUsuario(tipoDeUsuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id).orElse(null));
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
