package br.unisc.tcc_projeto.DTO;

import java.time.LocalDate; // Para dataRegistro se for LocalDate
// import java.time.LocalDateTime; // Se dataRegistro for LocalDateTime

public class AnamneseDTO {
    private Long id;
    private Long agendamentoId;
    private Long clienteId;
    private String clienteNome; // NOVO CAMPO
    private String dataRegistro; // Alterado para String (formato YYYY-MM-DD)
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
    private String habitos; // String JSON
    private String saudePes; // String JSON
    private String avaliacao; // String JSON
    private String foto; // String Base64 (sem prefixo "data:image/jpeg;base64,")

    public AnamneseDTO() {}

    public AnamneseDTO(
            Long id,
            Long agendamentoId,
            Long clienteId,
            String clienteNome, // Adicionado
            String dataRegistro, // Alterado para String
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
            String avaliacao,
            String foto // Alterado para String
    ) {
        this.id = id;
        this.agendamentoId = agendamentoId;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
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
        this.foto = foto;
    }

    // Getters e Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAgendamentoId() { return agendamentoId; }
    public void setAgendamentoId(Long agendamentoId) { this.agendamentoId = agendamentoId; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }

    public String getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(String dataRegistro) { this.dataRegistro = dataRegistro; }

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

    public String getHabitos() { return habitos; } // String JSON
    public void setHabitos(String habitos) { this.habitos = habitos; }

    public String getSaudePes() { return saudePes; } // String JSON
    public void setSaudePes(String saudePes) { this.saudePes = saudePes; }

    public String getAvaliacao() { return avaliacao; } // String JSON
    public void setAvaliacao(String avaliacao) { this.avaliacao = avaliacao; }

    public String getFoto() { return foto; } // String Base64
    public void setFoto(String foto) { this.foto = foto; }
}
