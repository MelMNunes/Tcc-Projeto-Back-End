package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.DTO.AgendamentoDTO;
import br.unisc.tcc_projeto.DTO.ConsultaDTO;
import br.unisc.tcc_projeto.entidades.Agendamento;
import br.unisc.tcc_projeto.entidades.Servico;
import br.unisc.tcc_projeto.entidades.Usuario;
import br.unisc.tcc_projeto.repositories.AgendamentoRepository;
import br.unisc.tcc_projeto.repositories.ServicoRepository;
import br.unisc.tcc_projeto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServicoRepository servicoRepository;

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
    public List<AgendamentoDTO> buscarAgendamentosPorCliente(Long clienteId) {
        // Verifica se o ID pertence a um usuário do tipo CLIENTE
        Usuario cliente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (!"CLIENTE".equals(cliente.getTipoDeUsuario())) {
            throw new RuntimeException("Usuário não é um cliente válido");
        }

        // Busca os agendamentos
        return agendamentoRepository.findByClienteId(clienteId).stream().map(agendamento -> {
            // Busca o nome do funcionário
            Usuario funcionario = usuarioRepository.findById(agendamento.getFuncionarioId())
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

            // Busca o nome do serviço
            Servico servico = servicoRepository.findById(agendamento.getServicoId())
                    .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

            return new AgendamentoDTO(
                    agendamento.getId(),
                    agendamento.getDataHora(),
                    cliente.getNome(),   // Nome do cliente
                    funcionario.getNome(), // Nome do funcionário
                    servico.getNome()    // Nome do serviço
            );

        }).collect(Collectors.toList());
    }

    // Método para buscar agendamentos por funcionário
    public List<AgendamentoDTO> buscarAgendamentosPorFuncionario(Long funcionarioId) {
        // Verifica se o ID pertence a um usuário do tipo FUNCIONARIO
        Usuario funcionario = usuarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if (!"FUNCIONARIO".equals(funcionario.getTipoDeUsuario())) {
            throw new RuntimeException("Usuário não é um funcionário válido");
        }

        // Busca os agendamentos relacionados ao funcionário
        return agendamentoRepository.findByFuncionarioId(funcionarioId).stream().map(agendamento -> {
            // Busca o nome do cliente
            Usuario cliente = usuarioRepository.findById(agendamento.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            // Busca o nome do serviço
            Servico servico = servicoRepository.findById(agendamento.getServicoId())
                    .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

            return new AgendamentoDTO(
                    agendamento.getId(),
                    agendamento.getDataHora(),
                    cliente.getNome(),   // Nome do cliente
                    funcionario.getNome(), // Nome do funcionário
                    servico.getNome()    // Nome do serviço
            );

        }).collect(Collectors.toList());
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

    // Método para desassociar agendamentos de um usuário pelo ID do usuário
    public void desassociarAgendamentosPorUsuarioId(Long usuarioId) {
        // Primeiro, busque os agendamentos relacionados ao cliente
        List<Agendamento> agendamentosComoCliente = agendamentoRepository.findByClienteId(usuarioId);
        for (Agendamento agendamento : agendamentosComoCliente) {
            agendamentoRepository.delete(agendamento); // Exclui ou desassocia
        }

        // Depois, busque os agendamentos relacionados ao funcionário
        List<Agendamento> agendamentosComoFuncionario = agendamentoRepository.findByFuncionarioId(usuarioId);
        for (Agendamento agendamento : agendamentosComoFuncionario) {
            agendamentoRepository.delete(agendamento); // Exclui ou desassocia
        }
    }

    public List<Agendamento> getHistoricoByFuncionarioId(Long funcionarioId) {
        return agendamentoRepository.findHistoricoByFuncionarioId(funcionarioId);
    }
}