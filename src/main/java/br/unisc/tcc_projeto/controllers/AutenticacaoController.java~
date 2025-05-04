package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.DTO.AuthResponse;
import br.unisc.tcc_projeto.DTO.LoginRequest;
import br.unisc.tcc_projeto.DTO.RegisterRequest;
import br.unisc.tcc_projeto.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationService authenticationService;


    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) throws Exception {
        AuthResponse response = authenticationService.authenticateUser(loginRequest);
        return ResponseEntity.ok(response);
    }


    // Cadastro Endpoint
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody RegisterRequest request) {
        try {
            // Garante que o tipo de usuário seja CLIENTE antes de registrar
            request.setTipoDeUsuario("CLIENTE");

            // Registra o usuário
            String response = authenticationService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
