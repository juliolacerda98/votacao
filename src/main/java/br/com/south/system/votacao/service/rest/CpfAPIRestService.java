package br.com.south.system.votacao.service.rest;

import br.com.south.system.votacao.controller.dto.ResponseCpfApiDTO;
import br.com.south.system.votacao.model.repository.rest.CpfAPIRestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CpfAPIRestService {

    private static Logger logger = LoggerFactory.getLogger(CpfAPIRestService.class);

    @Autowired
    private CpfAPIRestRepository restRepository;

    public void validaCpf(String cpf) {
        try {
            ResponseCpfApiDTO dto = restRepository.validaCpf(cpf);
            validaAptidaoParaVoto(dto);
        }catch (feign.FeignException e){
            logger.error("Não foi possivel validar o CPF!");
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Erro ao validar CPF!");
        }
    }

    private static void validaAptidaoParaVoto(ResponseCpfApiDTO dto) {
        if (dto.getStatus().equals("UNABLE_TO_VOTE")){
            logger.error("CPF não está apto para voto!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF não está apto para voto!");
        }
    }
}