//package br.unisc.tcc_projeto.controllers;
//
//import br.unisc.tcc_projeto.services.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api")
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    // Simulação de um "banco de dados"
//    private Map<String, String> tokens = new HashMap<>();
//
//    @PostMapping("/enviar-confirmacao")
//    public String enviarConfirmacao(@RequestParam String email) {
//        String token = UUID.randomUUID().toString();
//        tokens.put(token, email);  // Guarda o token e o e-mail
//
//        emailService.enviarEmailConfirmacao(email, token);
//        return "E-mail de confirmação enviado para " + email;
//    }
//
//    @GetMapping("/confirmar")
//    public String confirmarEmail(@RequestParam String token) {
//        if (tokens.containsKey(token)) {
//            String email = tokens.remove(token);  // Remove o token (confirmação única)
//            return "E-mail " + email + " confirmado com sucesso!";
//        } else {
//            return "Token inválido ou expirado!";
//        }
//    }
//}
//
