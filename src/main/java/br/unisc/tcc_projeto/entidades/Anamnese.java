package br.unisc.tcc_projeto.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "anamnese")
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "agendamento_id", nullable = false)
    private Long agendamentoId;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "genero")
    private String genero;

    @Column(name = "queixa_principal")
    private String queixaPrincipal;

    @Column(name = "tempo_problema")
    private String tempoProblema;

    @Column(name = "tratamento_anterior")
    private String tratamentoAnterior;

    @Column(name = "historia")
    private String historia;

    @Column(name = "doencas")
    private String doencas; // Pode ser uma string com as doenças separadas por vírgula

    @Column(name = "outra_doenca")
    private String outraDoenca;

    @Column(name = "cirurgia_recente")
    private String cirurgiaRecente;

    @Column(name = "alergia")
    private String alergia;

    @Column(name = "medicamentos")
    private String medicamentos;

    @Column(name = "produtos")
    private String produtos;

    @Column(name = "materiais")
    private String materiais;

    @Column(name = "historico_familiar")
    private String historicoFamiliar;

    @Column(name = "historico_familiar_especificar")
    private String historicoFamiliarEspecificar;

    @Column(name = "habitos")
    private String habitos; // Pode ser uma string com os hábitos

    @Column(name = "saude_pes")
    private String saudePes; // Pode ser uma string com as informações de saúde dos pés

    @Column(name = "avaliacao")
    private String avaliacao; // Pode ser uma string com as informações de avaliação

    // Construtores, getters e setters
    public Anamnese() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getTempoProblema() {
        return tempoProblema;
    }

    public void setTempoProblema(String tempoProblema) {
        this.tempoProblema = tempoProblema;
    }

    public String getTratamentoAnterior() {
        return tratamentoAnterior;
    }

    public void setTratamentoAnterior(String tratamentoAnterior) {
        this.tratamentoAnterior = tratamentoAnterior;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getOutraDoenca() {
        return outraDoenca;
    }

    public void setOutraDoenca(String outraDoenca) {
        this.outraDoenca = outraDoenca;
    }

    public String getCirurgiaRecente() {
        return cirurgiaRecente;
    }

    public void setCirurgiaRecente(String cirurgiaRecente) {
        this.cirurgiaRecente = cirurgiaRecente;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getMateriais() {
        return materiais;
    }

    public void setMateriais(String materiais) {
        this.materiais = materiais;
    }

    public String getHistoricoFamiliar() {
        return historicoFamiliar;
    }

    public void setHistoricoFamiliar(String historicoFamiliar) {
        this.historicoFamiliar = historicoFamiliar;
    }

    public String getHistoricoFamiliarEspecificar() {
        return historicoFamiliarEspecificar;
    }

    public void setHistoricoFamiliarEspecificar(String historicoFamiliarEspecificar) {
        this.historicoFamiliarEspecificar = historicoFamiliarEspecificar;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getSaudePes() {
        return saudePes;
    }

    public void setSaudePes(String saudePes) {
        this.saudePes = saudePes;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}