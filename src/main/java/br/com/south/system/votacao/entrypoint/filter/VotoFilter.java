package br.com.south.system.votacao.entrypoint.filter;

import br.com.south.system.votacao.domain.repository.VotoRepository;
import br.com.south.system.votacao.domain.repository.service.PautaRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class VotoFilter {

    @Autowired
    private VotoRepository repository;

    @Autowired
    private PautaRepositoryService pautaRepository;

    private static Logger logger = LoggerFactory.getLogger(VotoFilter.class);

    public void validaNovoVoto(final String pautaId, final String associadoId){
        if (!pautaRepository.buscaPorId(pautaId).isSessaoDisponivel()){
            logger.info("Sessão de votação para esta pauta não está disponivel!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sessão de votação para esta pauta não está disponivel!");
        }
        if (repository.findByAssociadoAndPauta(associadoId, pautaId).isPresent()){
            logger.info("Associado já votou nessa pauta!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Associado já votou nessa pauta!");
        }
    }
}