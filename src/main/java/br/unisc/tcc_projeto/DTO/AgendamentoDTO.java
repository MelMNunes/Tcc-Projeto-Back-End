package br.unisc.tcc_projeto.DTO;

import java.time.LocalDateTime;

public class AgendamentoDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String clienteNome;
    private String funcionarioNome;
    private String servicoNome;
    private String descricao;
    private String status;

    public AgendamentoDTO(Long id, LocalDateTime dataHora, String clienteNome, String funcionarioNome, String servicoNome, String descricao, String status) {
        this.id = id;
        this.dataHora = dataHora;
        this.clienteNome = clienteNome;
        this.funcionarioNome = funcionarioNome;
        this.servicoNome = servicoNome;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}