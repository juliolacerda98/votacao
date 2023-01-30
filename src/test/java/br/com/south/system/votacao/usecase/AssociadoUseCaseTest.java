package br.com.south.system.votacao.usecase;

import br.com.south.system.votacao.application.usecase.CpfAPIUseCase;
import br.com.south.system.votacao.application.usecase.impl.AssociadoUseCaseImpl;
import br.com.south.system.votacao.domain.Associado;
import br.com.south.system.votacao.domain.repository.service.AssociadoRepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AssociadoUseCaseTest {

    @Mock
    private AssociadoRepositoryService repository;

    @Mock
    private CpfAPIUseCase cpfAPIUseCase;

    @InjectMocks
    private AssociadoUseCaseImpl associadoUseCase;

    @Test
    public void validaNovoAssociado(){
        doNothing().when(cpfAPIUseCase).validaCpf(anyString());
        when(repository.salva(any(Associado.class))).thenAnswer(answer -> {
            return answer.getArgument(0);
        });
        Associado associado = associadoUseCase.novo("123456");
        assertNotNull(associado);
        assertEquals(associado.getCpf(), "123456");
    }
}
