package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.DTO.AnamneseDTO;
import br.unisc.tcc_projeto.entidades.Anamnese;
import br.unisc.tcc_projeto.entidades.Usuario; // Importar Usuario
import br.unisc.tcc_projeto.repositories.AnamneseRepository;
import br.unisc.tcc_projeto.repositories.UsuarioRepository; // Importar UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter; // Para formatar data
import java.util.Optional;

@Service
public class AnamneseService {

    @Autowired
    private AnamneseRepository anamneseRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Injetar para buscar nome do cliente

    @Transactional
    public Anamnese salvarOuAtualizarAnamnese(Anamnese anamnese) {
        if (anamnese.getId() != null) {
            Anamnese existente = anamneseRepository.findById(anamnese.getId())
                    .orElseThrow(() -> new RuntimeException("Anamnese não encontrada com ID: " + anamnese.getId() + " para atualização."));

            // Atualizar campos da anamnese existente
            existente.setClienteId(anamnese.getClienteId()); // Garanta que o clienteId não seja alterado indevidamente se já existir
            existente.setAgendamentoId(anamnese.getAgendamentoId()); // O mesmo para agendamentoId
            existente.setDataRegistro(anamnese.getDataRegistro());
            existente.setIdade(anamnese.getIdade());
            existente.setGenero(anamnese.getGenero());
            existente.setQueixaPrincipal(anamnese.getQueixaPrincipal());
            existente.setTempoProblema(anamnese.getTempoProblema());
            existente.setTratamentoAnterior(anamnese.getTratamentoAnterior());
            existente.setHistoria(anamnese.getHistoria());
            existente.setDoencas(anamnese.getDoencas());
            existente.setOutraDoenca(anamnese.getOutraDoenca());
            existente.setCirurgiaRecente(anamnese.getCirurgiaRecente());
            existente.setAlergia(anamnese.getAlergia());
            existente.setMedicamentos(anamnese.getMedicamentos());
            existente.setProdutos(anamnese.getProdutos());
            existente.setMateriais(anamnese.getMateriais());
            existente.setHistoricoFamiliar(anamnese.getHistoricoFamiliar());
            existente.setHistoricoFamiliarEspecificar(anamnese.getHistoricoFamiliarEspecificar());
            existente.setHabitos(anamnese.getHabitos()); // String JSON
            existente.setSaudePes(anamnese.getSaudePes()); // String JSON
            existente.setAvaliacao(anamnese.getAvaliacao()); // String JSON

            // Só atualiza a foto se uma nova foto for fornecida no payload da anamnese
            // Se anamnese.getFoto() for null e existente.getFoto() não for, mantém a foto antiga.
            // Se anamnese.getFoto() tiver dados, atualiza.
            if (anamnese.getFoto() != null) {
                existente.setFoto(anamnese.getFoto());
            }
            // Se você quiser permitir remover a foto, precisaria de uma lógica adicional,
            // por exemplo, se anamnese.getFoto() for uma string vazia indicando remoção.

            return anamneseRepository.save(existente);
        } else {
            // Nova anamnese
            return anamneseRepository.save(anamnese);
        }
    }

    public AnamneseDTO buscarPorAgendamentoId(Long agendamentoId) {
        Anamnese anamnese = anamneseRepository.findByAgendamentoId(agendamentoId);
        if (anamnese != null) {
            String nomeCliente = "Cliente não informado";
            if (anamnese.getClienteId() != null) {
                Optional<Usuario> clienteOpt = usuarioRepository.findById(anamnese.getClienteId());
                if (clienteOpt.isPresent()) {
                    nomeCliente = clienteOpt.get().getNome();
                }
            }

            // Formatar LocalDate para String "yyyy-MM-dd" para o DTO
            String dataRegistroFormatada = "";
            if (anamnese.getDataRegistro() != null) {
                dataRegistroFormatada = anamnese.getDataRegistro().format(DateTimeFormatter.ISO_LOCAL_DATE);
            }

            // Convert byte[] para String Base64 para o DTO
            String fotoBase64 = null;
            if (anamnese.getFoto() != null && anamnese.getFoto().length > 0) {
                fotoBase64 = java.util.Base64.getEncoder().encodeToString(anamnese.getFoto());
            }


            return new AnamneseDTO(
                    anamnese.getId(),
                    anamnese.getAgendamentoId(),
                    anamnese.getClienteId(),
                    nomeCliente,
                    dataRegistroFormatada, // Data formatada como String
                    anamnese.getIdade(),
                    anamnese.getGenero(),
                    anamnese.getQueixaPrincipal(),
                    anamnese.getTempoProblema(),
                    anamnese.getTratamentoAnterior(),
                    anamnese.getHistoria(),
                    anamnese.getDoencas(),
                    anamnese.getOutraDoenca(),
                    anamnese.getCirurgiaRecente(),
                    anamnese.getAlergia(),
                    anamnese.getMedicamentos(),
                    anamnese.getProdutos(),
                    anamnese.getMateriais(),
                    anamnese.getHistoricoFamiliar(),
                    anamnese.getHistoricoFamiliarEspecificar(),
                    anamnese.getHabitos(), // String JSON
                    anamnese.getSaudePes(), // String JSON
                    anamnese.getAvaliacao(), // String JSON
                    fotoBase64 // Foto como String Base64
            );
        }
        return null;
    }
}