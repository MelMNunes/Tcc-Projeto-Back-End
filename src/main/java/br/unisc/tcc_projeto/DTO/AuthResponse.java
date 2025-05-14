package br.unisc.tcc_projeto.DTO;

public class AuthResponse {
    private String token;
    private String tipoDeUsuario;
    private String nome;
    private Long id;
    private String cpf;       // Novo campo
    private String telefone;  // Novo campo

    // Construtor atualizado
    public AuthResponse(String token, String tipoDeUsuario, String nome, Long id, String cpf, String telefone) {
        this.token = token;
        this.tipoDeUsuario = tipoDeUsuario;
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters (e Setters, se necessário)
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}