package br.com.south.system.votacao.service;

import br.com.south.system.votacao.model.Voto;
import br.com.south.system.votacao.model.enumerated.TipoVoto;
import br.com.south.system.votacao.model.repository.service.AssociadoRepositoryService;
import br.com.south.system.votacao.model.repository.service.PautaRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private PautaService pautaService;

    @Autowired
    private AssociadoRepositoryService associadoRepositoryService;

    @Autowired
    private PautaRepositoryService pautaRepositoryService;

    public Voto novo(String associadoId, TipoVoto tipoVoto, String pautaId) {
        Voto voto = new Voto(tipoVoto, associadoRepositoryService.buscaPorId(associadoId), pautaRepositoryService.buscaPorId(pautaId));
        pautaService.contabilizaVoto(pautaId, voto);
        return voto;
    }
}