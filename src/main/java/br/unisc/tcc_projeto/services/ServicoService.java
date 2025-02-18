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
}
