package br.com.south.system.votacao.application.usecase.impl;

import br.com.south.system.votacao.application.usecase.AssociadoUseCase;
import br.com.south.system.votacao.application.usecase.CpfAPIUseCase;
import br.com.south.system.votacao.domain.Associado;
import br.com.south.system.votacao.domain.repository.service.AssociadoRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoUseCaseImpl implements AssociadoUseCase {

    @Autowired
    private AssociadoRepositoryService repository;

    @Autowired
    private CpfAPIUseCase cpfAPIUseCase;

    @Override
    public Associado novo(String cpf) {
        cpfAPIUseCase.validaCpf(cpf);
        return repository.salva(new Associado(cpf));
    }
}