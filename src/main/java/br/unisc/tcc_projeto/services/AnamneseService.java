package br.unisc.tcc_projeto.services;

import br.unisc.tcc_projeto.DTO.AnamneseDTO;
import br.unisc.tcc_projeto.entidades.Anamnese;
import br.unisc.tcc_projeto.repositories.AnamneseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.stream.LangCollectors.collect;

@Service
public class AnamneseService {

    @Autowired
    private AnamneseRepository anamneseRepository;

    // Método para salvar uma nova anamnese
    public Anamnese salvarAnamnese(Anamnese anamnese) {
        return anamneseRepository.save(anamnese);
    }

    // Método para buscar anamneses por cliente
    public List<AnamneseDTO> buscarPorClienteId(Long clienteId) {
        List<Anamnese> anamneses = anamneseRepository.findByClienteId(clienteId);
        return anamneses.stream()
                .map(anamnese -> new AnamneseDTO(
                        anamnese.getId(),
                        anamnese.getAgendamentoId(),
                        anamnese.getClienteId(),
                        anamnese.getDataRegistro(),
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
                        anamnese.getHabitos(),
                        anamnese.getSaudePes(),
                        anamnese.getAvaliacao()
                ))
                .collect(Collectors.toList());
    }


}