package br.unisc.tcc_projeto.DTO;

import java.time.LocalDate;

public class AnamneseDTO {
    private Long id;
    private Long agendamentoId;
    private Long clienteId;
    private LocalDate dataRegistro;
    private Integer idade;
    private String genero;
    private String queixaPrincipal;
    private String tempoProblema;
    private String tratamentoAnterior;
    private String historia;
    private String doencas;
    private String outraDoenca;
    private String cirurgiaRecente;
    private String alergia;
    private String medicamentos;
    private String produtos;
    private String materiais;
    private String historicoFamiliar;
    private String historicoFamiliarEspecificar;
    private String habitos;
    private String saudePes;
    private String avaliacao;

    public AnamneseDTO() {}

    public AnamneseDTO(
            Long id,
            Long agendamentoId,
            Long clienteId,
            LocalDate dataRegistro,
            Integer idade,
            String genero,
            String queixaPrincipal,
            String tempoProblema,
            String tratamentoAnterior,
            String historia,
            String doencas,
            String outraDoenca,
            String cirurgiaRecente,
            String alergia,
            String medicamentos,
            String produtos,
            String materiais,
            String historicoFamiliar,
            String historicoFamiliarEspecificar,
            String habitos,
            String saudePes,
            String avaliacao
    ) {
        this.id = id;
        this.agendamentoId = agendamentoId;
        this.clienteId = clienteId;
        this.dataRegistro = dataRegistro;
        this.idade = idade;
        this.genero = genero;
        this.queixaPrincipal = queixaPrincipal;
        this.tempoProblema = tempoProblema;
        this.tratamentoAnterior = tratamentoAnterior;
        this.historia = historia;
        this.doencas = doencas;
        this.outraDoenca = outraDoenca;
        this.cirurgiaRecente = cirurgiaRecente;
        this.alergia = alergia;
        this.medicamentos = medicamentos;
        this.produtos = produtos;
        this.materiais = materiais;
        this.historicoFamiliar = historicoFamiliar;
        this.historicoFamiliarEspecificar = historicoFamiliarEspecificar;
        this.habitos = habitos;
        this.saudePes = saudePes;
        this.avaliacao = avaliacao;
    }

    // Getters e setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAgendamentoId() { return agendamentoId; }
    public void setAgendamentoId(Long agendamentoId) { this.agendamentoId = agendamentoId; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getQueixaPrincipal() { return queixaPrincipal; }
    public void setQueixaPrincipal(String queixaPrincipal) { this.queixaPrincipal = queixaPrincipal; }

    public String getTempoProblema() { return tempoProblema; }
    public void setTempoProblema(String tempoProblema) { this.tempoProblema = tempoProblema; }

    public String getTratamentoAnterior() { return tratamentoAnterior; }
    public void setTratamentoAnterior(String tratamentoAnterior) { this.tratamentoAnterior = tratamentoAnterior; }

    public String getHistoria() { return historia; }
    public void setHistoria(String historia) { this.historia = historia; }

    public String getDoencas() { return doencas; }
    public void setDoencas(String doencas) { this.doencas = doencas; }

    public String getOutraDoenca() { return outraDoenca; }
    public void setOutraDoenca(String outraDoenca) { this.outraDoenca = outraDoenca; }

    public String getCirurgiaRecente() { return cirurgiaRecente; }
    public void setCirurgiaRecente(String cirurgiaRecente) { this.cirurgiaRecente = cirurgiaRecente; }

    public String getAlergia() { return alergia; }
    public void setAlergia(String alergia) { this.alergia = alergia; }

    public String getMedicamentos() { return medicamentos; }
    public void setMedicamentos(String medicamentos) { this.medicamentos = medicamentos; }

    public String getProdutos() { return produtos; }
    public void setProdutos(String produtos) { this.produtos = produtos; }

    public String getMateriais() { return materiais; }
    public void setMateriais(String materiais) { this.materiais = materiais; }

    public String getHistoricoFamiliar() { return historicoFamiliar; }
    public void setHistoricoFamiliar(String historicoFamiliar) { this.historicoFamiliar = historicoFamiliar; }

    public String getHistoricoFamiliarEspecificar() { return historicoFamiliarEspecificar; }
    public void setHistoricoFamiliarEspecificar(String historicoFamiliarEspecificar) { this.historicoFamiliarEspecificar = historicoFamiliarEspecificar; }

    public String getHabitos() { return habitos; }
    public void setHabitos(String habitos) { this.habitos = habitos; }

    public String getSaudePes() { return saudePes; }
    public void setSaudePes(String saudePes) { this.saudePes = saudePes; }

    public String getAvaliacao() { return avaliacao; }
    public void setAvaliacao(String avaliacao) { this.avaliacao = avaliacao; }
}
