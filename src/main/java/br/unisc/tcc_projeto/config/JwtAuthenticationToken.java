package br.unisc.tcc_projeto.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String username;

    public JwtAuthenticationToken(String username) {
        super(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Definindo uma role padrão (pode ser ajustado)
        this.username = username;
        setAuthenticated(true); // Define como autenticado
    }

    @Override
    public Object getCredentials() {
        return null;  // Não usamos credenciais explícitas neste caso
    }

    @Override
    public Object getPrincipal() {
        return username;  // O principal é o nome de usuário
    }
}
