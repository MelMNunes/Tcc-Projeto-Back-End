//package br.unisc.tcc_projeto.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void enviarEmailConfirmacao(String destinatario, String token) {
//        String linkConfirmacao = "http://localhost:8080/api/confirmar?token=" + token;
//
//        SimpleMailMessage mensagem = new SimpleMailMessage();
//        mensagem.setTo(destinatario);
//        mensagem.setSubject("Confirme seu e-mail");
//        mensagem.setText("Clique no link para confirmar seu e-mail: " + linkConfirmacao);
//
//        mailSender.send(mensagem);
//    }
//}
//
