package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Método para buscar agendamentos por cliente
    List<Agendamento> findByClienteId(Long clienteId);
}