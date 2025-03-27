package br.unisc.tcc_projeto.controllers;

import br.unisc.tcc_projeto.services.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
public class WhatsAppController {

    @Autowired
    private WhatsAppService whatsAppService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest) {
        String response = whatsAppService.sendMessage(messageRequest.getPhone(), messageRequest.getMessage());
        return ResponseEntity.ok(response);
    }

    public static class MessageRequest {
        private String phone;
        private String message;

        // Getters e Setters
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}