package br.com.south.system.votacao.application.usecase;

import br.com.south.system.votacao.domain.Associado;

public interface AssociadoUseCase {

    Associado novo(final String cpf);
}