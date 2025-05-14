package br.unisc.tcc_projeto.repositories;

import br.unisc.tcc_projeto.entidades.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByClienteId(Long clienteId);

    List<Agendamento> findByFuncionarioId(Long funcionarioId);

    // Busca agendamentos por funcionário e status específico
    List<Agendamento> findByFuncionarioIdAndStatus(Long funcionarioId, String status);

    @Query("SELECT a FROM Agendamento a WHERE a.funcionarioId = :funcionarioId")
    List<Agendamento> findHistoricoByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    // Query MODIFICADA/ADICIONADA: Busca agendamentos de um funcionário em uma data, EXCLUINDO os cancelados.
    // Esta será usada para determinar os horários realmente ocupados.
    @Query("SELECT a FROM Agendamento a WHERE DATE(a.dataHora) = :data AND a.funcionarioId = :funcionarioId AND UPPER(a.status) <> 'CANCELADO'")
    List<Agendamento> findByFuncionarioIdAndDataAndStatusNotCancelled(@Param("funcionarioId") Long funcionarioId, @Param("data") LocalDate data);

    // Query para buscar agendamentos de um funcionário em uma data (incluindo todos os status, pode ser usada para outras listagens)
    @Query("SELECT a FROM Agendamento a WHERE DATE(a.dataHora) = :data AND a.funcionarioId = :funcionarioId")
    List<Agendamento> findByFuncionarioIdAndData(@Param("funcionarioId") Long funcionarioId, @Param("data") LocalDate data);


    List<Agendamento> findByFuncionarioIdAndDataHoraBetween(
            Long funcionarioId,
            LocalDateTime startDate,
            LocalDateTime endDate
    );

    @Query("SELECT a FROM Agendamento a WHERE UPPER(a.status) = UPPER(:status) ORDER BY a.dataHora ASC")
    List<Agendamento> findByStatusOrderByDataHoraAsc(@Param("status") String status);
}