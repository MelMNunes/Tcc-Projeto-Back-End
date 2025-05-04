package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Método para buscar agendamentos por cliente
    List<Agendamento> findByClienteId(Long clienteId);

    List<Agendamento> findByFuncionarioId(Long funcionarioId);

    @Query("SELECT a FROM Agendamento a WHERE a.funcionarioId = :funcionarioId")
    List<Agendamento> findHistoricoByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    @Query("SELECT a FROM Agendamento a WHERE DATE(a.dataHora) = :data AND a.funcionarioId = :funcionarioId")
    List<Agendamento> findByFuncionarioIdAndData(Long funcionarioId, LocalDate data);

}