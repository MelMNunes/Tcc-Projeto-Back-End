package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.DTO.AnamneseDTO;
import br.unisc.tcc_projeto.entidades.Anamnese;
import br.unisc.tcc_projeto.services.AnamneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anamnese")
public class AnamneseController {

    @Autowired
    private AnamneseService anamneseService;

    @PostMapping("/criar")
    public ResponseEntity<Anamnese> criarAnamnese(@RequestBody Anamnese anamnese) {
        try {
            Anamnese novaAnamnese = anamneseService.salvarAnamnese(anamnese);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaAnamnese);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Buscar anamneses por cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<AnamneseDTO>> getAnamnesesPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(anamneseService.buscarPorClienteId(clienteId));
    }
}