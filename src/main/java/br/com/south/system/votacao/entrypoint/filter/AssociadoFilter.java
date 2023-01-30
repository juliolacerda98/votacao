package br.com.south.system.votacao.entrypoint.filter;

import br.com.south.system.votacao.domain.repository.AssociadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AssociadoFilter {

    @Autowired
    private AssociadoRepository repository;

    private static Logger logger = LoggerFactory.getLogger(AssociadoFilter.class);

    public void validaNovoAssociado(final String cpf){
        if(repository.findByCpf(cpf).isPresent()){
            logger.error("Já existe um associado cadastrado com esse CPF!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um associado cadastrado com esse CPF!");
        }
    }
}