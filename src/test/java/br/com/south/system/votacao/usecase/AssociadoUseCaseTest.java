package br.com.south.system.votacao.usecase;

import br.com.south.system.votacao.service.AssociadoService;
import br.com.south.system.votacao.model.Associado;
import br.com.south.system.votacao.model.repository.service.AssociadoRepositoryService;
import br.com.south.system.votacao.service.rest.CpfAPIRestService;
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
    private CpfAPIRestService cpfAPIService;

    @InjectMocks
    private AssociadoService associadoUseCase;

    @Test
    public void validaNovoAssociado(){
        doNothing().when(cpfAPIService).validaCpf(anyString());
        when(repository.salva(any(Associado.class))).thenAnswer(answer -> {
            return answer.getArgument(0);
        });
        Associado associado = associadoUseCase.novo("123456");
        assertNotNull(associado);
        assertEquals(associado.getCpf(), "123456");
    }
}
