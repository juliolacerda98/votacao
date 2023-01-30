package br.com.south.system.votacao.entrypoint.filter;

import br.com.south.system.votacao.domain.repository.PautaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Component
public class PautaFilter {

    @Autowired
    private PautaRepository repository;

    private static Logger logger = LoggerFactory.getLogger(PautaFilter.class);

    public void validaNovaPauta (final String nome){
        if (repository.findByNome(nome).isPresent()){
            logger.info("Já existe uma pauta criada com esse nome!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma pauta criada com esse nome!");
        }
    }

    public void validaAberturaSessao (final String pautaId, final LocalDateTime dataExpiracao){
        if (dataExpiracao.isBefore(LocalDateTime.now())){
            logger.error("Data de expiração de sessão inválida!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de expiração de sessão inválida!");
        }
    }
}