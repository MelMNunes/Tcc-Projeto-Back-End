package br.unisc.tcc_projeto.DTO;

public class AuthResponse {
    private String token;
    private String tipoDeUsuario;

    public AuthResponse(String token, String tipoDeUsuario, String nome) {
        this.token = token;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}