package br.com.south.system.votacao.application.usecase;

import br.com.south.system.votacao.domain.Voto;
import br.com.south.system.votacao.domain.enumerated.TipoVoto;

public interface VotoUseCase {

    Voto novo(final String cpf, final TipoVoto voto, final String pautaId);
}