package br.com.south.system.votacao.application.usecase;

import br.com.south.system.votacao.domain.Pauta;
import br.com.south.system.votacao.domain.Voto;

import java.time.LocalDateTime;

public interface PautaUseCase {

    Pauta nova(final String nome);

    Pauta abreSessao(final String id, final LocalDateTime dataExpiracao);

    Pauta contabilizaVoto(final String id, final Voto voto);
}