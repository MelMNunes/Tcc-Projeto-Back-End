package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.DTO.AuthResponse;
import br.unisc.tcc_projeto.DTO.LoginRequest;
import br.unisc.tcc_projeto.DTO.RegisterRequest;
import br.unisc.tcc_projeto.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationService authenticationService;


    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authenticationService.authenticateUser (loginRequest);
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + e.getMessage());
        }
    }


    // Cadastro
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
