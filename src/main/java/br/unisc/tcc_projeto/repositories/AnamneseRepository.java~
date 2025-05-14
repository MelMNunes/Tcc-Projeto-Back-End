package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
    List<Anamnese> findByClienteId(Long clienteId); // Novo método
}
