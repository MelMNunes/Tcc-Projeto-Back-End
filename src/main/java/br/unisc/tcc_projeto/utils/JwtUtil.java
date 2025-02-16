package br.unisc.tcc_projeto.utils;

import br.unisc.tcc_projeto.entidades.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Gerar uma chave segura de 512 bits
    private static final Key jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Chave segura de 512 bits
    private static final int jwtExpirationMs = 86400000; // 24 horas em milissegundos

    // Gerar token JWT
    public static String generateJwtToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())// Ou outro identificador único
                .claim("nome: ", usuario.getNome()) // Adicionando um claim personalizado
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(jwtSecret) // Usando a chave segura gerada
                .compact();
    }

    // Obter username do token JWT
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder() // Usar o parserBuilder, que é o método mais moderno e recomendado
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validar token JWT
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder() // Usando o parserBuilder
                    .setSigningKey(jwtSecret)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.err.println("Assinatura inválida: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.println("Token JWT malformado: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.println("Token JWT expirado: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println("Token JWT não suportado: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Token JWT vazio ou inválido: " + e.getMessage());
        }
        return false;
    }
}
