package br.com.south.system.votacao.service;

import br.com.south.system.votacao.model.Associado;
import br.com.south.system.votacao.model.repository.service.AssociadoRepositoryService;
import br.com.south.system.votacao.service.rest.CpfAPIRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepositoryService repositoryService;

    @Autowired
    private CpfAPIRestService restService;

    public Associado novo(String cpf) {
        restService.validaCpf(cpf);
        return repositoryService.salva(new Associado(cpf));
    }
}