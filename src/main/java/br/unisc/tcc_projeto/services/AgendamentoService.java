package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.entidades.Agendamento;
import br.unisc.tcc_projeto.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Método para criar um novo agendamento
    public Agendamento criarAgendamento(Agendamento agendamento) {
        // Aqui você pode adicionar lógica adicional, como validações
        return agendamentoRepository.save(agendamento);
    }

    // Método para buscar todos os agendamentos
    public List<Agendamento> buscarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    // Método para buscar agendamentos por cliente
    public List<Agendamento> buscarAgendamentosPorCliente(Long clienteId) {
        return agendamentoRepository.findByClienteId(clienteId);
    }

    // Método para buscar um agendamento por ID
    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }

    // Método para atualizar um agendamento
    public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
        // Verifica se o agendamento existe
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        agendamentoAtualizado.setId(id); // Define o ID do agendamento a ser atualizado
        return agendamentoRepository.save(agendamentoAtualizado);
    }

    // Método para cancelar um agendamento (opcional)
    public void cancelarAgendamento(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }
}