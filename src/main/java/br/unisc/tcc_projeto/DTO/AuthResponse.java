package br.unisc.tcc_projeto.DTO;

public class AuthResponse {
    private String token;
    private String tipoDeUsuario;
    private String nome;
    private Long id;

    public AuthResponse(String token, String tipoDeUsuario, String nome, Long id) {
        this.token = token;
        this.tipoDeUsuario = tipoDeUsuario;
        this.nome = nome;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}