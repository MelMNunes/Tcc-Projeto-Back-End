package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.entidades.Servico;
import br.unisc.tcc_projeto.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = servicoService.listarServicos();
        return ResponseEntity.ok(servicos);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Servico> cadastrarServico(@RequestBody Servico servico) {
        Servico novoServico = servicoService.salvarServico(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirServico(@PathVariable Long id) {
        servicoService.excluirServico(id);
        return ResponseEntity.ok("Serviço excluído com sucesso!");
    }
}


