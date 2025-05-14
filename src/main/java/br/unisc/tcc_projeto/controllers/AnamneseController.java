package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.DTO.AnamneseDTO;
import br.unisc.tcc_projeto.entidades.Anamnese;
import br.unisc.tcc_projeto.services.AnamneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anamnese")
public class AnamneseController {

    @Autowired
    private AnamneseService anamneseService;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarNovaAnamnese(@RequestBody Anamnese anamnese) { // Renomeei o método para clareza
        try {
            // Logs para depuração do que o frontend enviou
            System.out.println("AnamneseController - /salvar - Payload recebido - Anamnese ID: " + anamnese.getId());
            System.out.println("AnamneseController - /salvar - Payload recebido - Agendamento ID: " + anamnese.getAgendamentoId());
            System.out.println("AnamneseController - /salvar - Payload recebido - Cliente ID: " + anamnese.getClienteId());

            // 1. Validação primária: Este endpoint é para CRIAR.
            // O ID da anamnese vindo do payload DEVE ser nulo.
            if (anamnese.getId() != null) {
                System.out.println("AnamneseController - /salvar - ERRO: ID da Anamnese (" + anamnese.getId() + ") não é nulo. Este endpoint é apenas para criar novas anamneses.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Para atualizar um registro existente, use o endpoint PUT /api/anamnese/atualizar/{id}. O ID da anamnese deve ser nulo para criação.");
            }

            // 2. Validações de campos obrigatórios para uma NOVA anamnese
            if (anamnese.getAgendamentoId() == null) {
                System.out.println("AnamneseController - /salvar - ERRO: Agendamento ID é obrigatório para nova anamnese.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Agendamento ID é obrigatório para nova anamnese.");
            }
            if (anamnese.getClienteId() == null) {
                System.out.println("AnamneseController - /salvar - ERRO: Cliente ID é obrigatório para nova anamnese.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente ID é obrigatório para nova anamnese.");
            }

            // 3. Se passou nas verificações e o ID é nulo, então é uma criação.
            // Chame o serviço. O serviço salvarOuAtualizarAnamnese, ao receber um objeto Anamnese com ID nulo,
            // irá tratá-lo como uma nova inserção.
            System.out.println("AnamneseController - /salvar - ID da anamnese é nulo. Prosseguindo para chamar o serviço de salvar/atualizar (que deve criar)...");
            Anamnese anamneseCriada = anamneseService.salvarOuAtualizarAnamnese(anamnese);

            System.out.println("AnamneseController - /salvar - Anamnese criada com sucesso. ID gerado: " + anamneseCriada.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(anamneseCriada);

        } catch (RuntimeException e) {
            System.out.println("AnamneseController - /salvar - ERRO RuntimeException: " + e.getMessage());
            // Adicionar e.printStackTrace() pode ajudar a ver o stack trace completo no console do servidor se o erro for inesperado
            // e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar requisição para salvar anamnese: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar/{anamneseId}")
    public ResponseEntity<?> atualizarAnamneseExistente(@PathVariable Long anamneseId, @RequestBody Anamnese anamneseDetalhes) {
        try {
            anamneseDetalhes.setId(anamneseId); // Garante que o ID da URL seja usado

            if (anamneseDetalhes.getAgendamentoId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Agendamento ID é obrigatório para atualização.");
            }
            if (anamneseDetalhes.getClienteId() == null) { // Cliente ID também deve ser validado
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente ID é obrigatório para atualização.");
            }

            Anamnese anamneseAtualizada = anamneseService.salvarOuAtualizarAnamnese(anamneseDetalhes);
            return ResponseEntity.ok(anamneseAtualizada);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Anamnese não encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/agendamento/{agendamentoId}")
    public ResponseEntity<AnamneseDTO> getAnamnesePorAgendamentoId(@PathVariable Long agendamentoId) {
        AnamneseDTO anamnese = anamneseService.buscarPorAgendamentoId(agendamentoId);
        if (anamnese != null) {
            return ResponseEntity.ok(anamnese);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
