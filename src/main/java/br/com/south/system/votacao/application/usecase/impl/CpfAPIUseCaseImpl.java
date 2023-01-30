package br.com.south.system.votacao.application.usecase.impl;

import br.com.south.system.votacao.application.usecase.CpfAPIUseCase;
import br.com.south.system.votacao.domain.repository.CpfAPIRepository;
import br.com.south.system.votacao.entrypoint.dto.ResponseCpfApiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CpfAPIUseCaseImpl implements CpfAPIUseCase {

    private static Logger logger = LoggerFactory.getLogger(CpfAPIUseCaseImpl.class);

    @Autowired
    private CpfAPIRepository cpfAPIRepository;

    @Override
    public void validaCpf(String cpf) {
        try {
            ResponseCpfApiDTO dto = cpfAPIRepository.validaCpf(cpf);
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