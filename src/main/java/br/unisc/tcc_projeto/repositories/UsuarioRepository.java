package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Servico;
import br.unisc.tcc_projeto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailOrCpfOrTelefone(String email, String cpf, String telefone); //Busca o usuário pelo email ou cpf ou telefone
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByTelefone(String telefone);

    @Query("SELECT u FROM Usuario u WHERE u.email = :login OR u.cpf = :login OR u.telefone = :login")
    Optional<Usuario> findByLogin(@Param("login") String login);

    List<Usuario> findByTipoDeUsuario (String tipoDeUsuario);

    @Query("SELECT u FROM Usuario u WHERE u.tipoDeUsuario = :tipo")
    List<Usuario> listarUsuarioPorTipo(@Param("tipo") String tipoDeUsuario);

    List<Usuario> findBytipoDeUsuario(String tipoDeUsuario);

}
