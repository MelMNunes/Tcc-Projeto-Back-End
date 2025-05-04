package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.DTO.AgendamentoDTO;
import br.unisc.tcc_projeto.entidades.Agendamento;
import br.unisc.tcc_projeto.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Endpoint para criar um novo agendamento
    @PostMapping("/criar")
    public ResponseEntity<?> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            Agendamento novoAgendamento = agendamentoService.salvarAgendamento(agendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint para buscar todos os agendamentos
    @GetMapping("buscar/todos")
    public ResponseEntity<List<Agendamento>> buscarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    // Endpoint para buscar agendamentos por cliente
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentosPorCliente(@PathVariable Long clienteId) {
        List<AgendamentoDTO> agendamentos = agendamentoService.buscarAgendamentosPorCliente(clienteId);
        return ResponseEntity.ok(agendamentos);
    }

    // Endpoint para buscar agendamentos por funcionario
    @GetMapping("/funcionarios/{funcionarioId}")
    public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentosPorFuncionario(@PathVariable Long funcionarioId) {
        List<AgendamentoDTO> agendamentos = agendamentoService.buscarAgendamentosPorFuncionario(funcionarioId);
        if (agendamentos == null || agendamentos.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>()); // Return an empty list if no appointments found
        }
        return ResponseEntity.ok(agendamentos);
    }


    // Endpoint para buscar um agendamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgendamentoPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar um agendamento
    @PutMapping("/{agendamentoId}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long agendamentoId, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(agendamentoId, agendamento);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    // Endpoint para cancelar um agendamento
    @DeleteMapping("/cancelar/{agendamentoId}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long agendamentoId) {
        try {
            agendamentoService.cancelarAgendamento(agendamentoId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }   }

    @GetMapping("/historico/{funcionarioId}")
    public ResponseEntity<List<Agendamento>> getHistorico(@PathVariable Long funcionarioId) {
        List<Agendamento> historico = agendamentoService.getHistoricoByFuncionarioId(funcionarioId);
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<?> buscarHorariosDisponiveis(
            @RequestParam String data,
            @RequestParam Long funcionarioId
    ) {
        List<String> horarios = agendamentoService.buscarHorariosOcupados(data, funcionarioId);
        return ResponseEntity.ok().body(Map.of("horariosOcupados", horarios));
    }

    @PutMapping("/atualizar-status/{agendamentoId}")
    public ResponseEntity<Agendamento> atualizarStatus(@PathVariable Long agendamentoId, @RequestBody String novoStatus) {
        try {
            // Remove aspas da string recebida, que vem como "\"FINALIZADO\""
            novoStatus = novoStatus.replace("\"", "");

            Agendamento agendamento = agendamentoService.buscarAgendamentoPorId(agendamentoId)
                    .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

            agendamento.setStatus(novoStatus);
            Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(agendamentoId, agendamento);

            return ResponseEntity.ok(agendamentoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/funcionarios/{funcionarioId}/status/{status}")
    public ResponseEntity<List<AgendamentoDTO>> buscarAgendamentosPorFuncionarioEStatus(
            @PathVariable Long funcionarioId,
            @PathVariable String status) {
        try {
            List<AgendamentoDTO> agendamentosFiltrados = agendamentoService
                    .buscarAgendamentosPorFuncionarioEStatus(funcionarioId, status);
            return ResponseEntity.ok(agendamentosFiltrados);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



}