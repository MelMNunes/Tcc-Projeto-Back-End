package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.entidades.Agendamento;
import br.unisc.tcc_projeto.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Endpoint para criar um novo agendamento
    @PostMapping("/criar")
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return ResponseEntity.ok(novoAgendamento);
    }

    // Endpoint para buscar todos os agendamentos
    @GetMapping("buscar/todos")
    public ResponseEntity<List<Agendamento>> buscarTodosAgendamentos() {
        List<Agendamento> agendamentos = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    // Endpoint para buscar agendamentos por cliente
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<Agendamento>> buscarAgendamentosPorCliente(@PathVariable Long clienteId) {
        List<Agendamento> agendamentos = agendamentoService.buscarAgendamentosPorCliente(clienteId);
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
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAtualizado = agendamentoService.atualizarAgendamento(id, agendamento);
        return ResponseEntity.ok(agendamentoAtualizado);
    }

    // Endpoint para cancelar um agendamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}