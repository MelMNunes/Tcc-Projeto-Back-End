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

    /**
     * Busca um usuário por email, CPF ou telefone.
     *
     * @param login - Pode ser email, CPF ou telefone
     * @return Usuario encontrado ou null
     */
    public Usuario buscarPorEmailCpfOuTelefone(String login) {
        Optional<Usuario> usuario = usuarioRepository.findByEmailOrCpfOrTelefone(login, login, login);
        return usuario.orElse(null); // Retorna o usuário ou null caso não encontrado
    }

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @param usuario - Dados do usuário a ser salvo
     * @return Usuario salvo
     */
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Verifica se um usuário existe por email, CPF ou telefone.
     *
     * @param login - Pode ser email, CPF ou telefone
     * @return true se o usuário existir, false caso contrário
     */
    public boolean usuarioExiste(String login) {
        return usuarioRepository.findByEmailOrCpfOrTelefone(login, login, login).isPresent();
    }

    public List

    /**
     * Retorna todos os usuários do sistema.
     *
     * @return Lista de usuários
     */
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Retorna todos os funcionários cadastrados no sistema.
     *
     * @return Lista de funcionários
     */
    public List<Usuario> listarFuncionarios() {
        return usuarioRepository.findByTipoDeUsuario("FUNCIONARIO");
    }

    /**
     * Retorna todos os administradores cadastrados no sistema.
     *
     * @return Lista de administradores
     */
    public List<Usuario> listarAdministradores() {
        return usuarioRepository.findByTipoDeUsuario("ADMINISTRADOR");
    }

    /**
     * Retorna todos os clientes cadastrados no sistema.
     *
     * @return Lista de clientes
     */
    public List<Usuario> listarClientes() {
        return usuarioRepository.findByTipoDeUsuario("CLIENTE");
    }

    /**
     * Lista usuários pelo tipo informado (CLIENTE, FUNCIONARIO, ADMINISTRADOR).
     *
     * @param tipoDeUsuario Tipo de usuário a ser listado
     * @return Lista de usuários do tipo especificado
     */
    public List<Usuario> listarUsuarioPorTipo(String tipoDeUsuario) {
        return usuarioRepository.findByTipoDeUsuario(tipoDeUsuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id).orElse(null));
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
