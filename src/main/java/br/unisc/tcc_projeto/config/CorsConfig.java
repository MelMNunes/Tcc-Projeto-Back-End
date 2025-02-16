package br.unisc.tcc_projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Adicionando CORS para todos os endpoints
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // URL do frontend
                .allowedHeaders("*") // Permite todos os headers
                .allowedMethods("*") // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowCredentials(true); // Permite o envio de cookies e credenciais
    }
}
