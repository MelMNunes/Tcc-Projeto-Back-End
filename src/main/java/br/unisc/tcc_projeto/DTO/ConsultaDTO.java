package br.unisc.tcc_projeto.DTO;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String servicoNome;
    private String clienteNome;

    public ConsultaDTO(Long id, LocalDateTime dataHora, String servicoNome, String clienteNome) {
        this.id = id;
        this.dataHora = dataHora;
        this.servicoNome = servicoNome;
        this.clienteNome = clienteNome;
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

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}