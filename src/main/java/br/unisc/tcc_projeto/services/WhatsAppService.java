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
    private static final String TOKEN = "6b62cd32d432ada74b7fc42d35e975e40fb0eeb847d7dda0172d36564018cfa7f89cffa98f3647bd"; // Substitua pelo seu token

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
