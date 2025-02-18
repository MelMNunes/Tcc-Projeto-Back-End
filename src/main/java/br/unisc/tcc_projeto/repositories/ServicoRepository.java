package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findAll();
}

