package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.entidades.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisc.tcc_projeto.repositories.ServicoRepository;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(Long id) {
        return servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Serviço não encontrado"));
    }

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void excluirServico(Long id) {
        servicoRepository.deleteById(id);
    }
}
