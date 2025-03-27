package br.unisc.tcc_projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhatsAppService {

    private static final String WALI_CHAT_URL = "https://api.wali.chat/v1/messages";
    private static final String TOKEN = "0f2d95328f00d15bfadf10c0a45637cc44887b111f9af7fe2f9004ebd5b3c7d8f2c4359adf72b609"; // Substitua pelo seu token

    @Autowired
    private RestTemplate restTemplate;

    public String sendMessage(String phone, String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Token", TOKEN);

        String requestBody = String.format("{\"phone\": \"%s\", \"message\": \"%s\"}", phone, message);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(WALI_CHAT_URL, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return "Mensagem enviada com sucesso: " + response.getBody();
        } else {
            throw new RuntimeException("Erro ao enviar mensagem: " + response.getStatusCode());
        }
    }
}
