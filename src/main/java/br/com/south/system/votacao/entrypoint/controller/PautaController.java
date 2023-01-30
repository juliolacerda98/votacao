package br.com.south.system.votacao.entrypoint.controller;

import br.com.south.system.votacao.application.usecase.PautaUseCase;
import br.com.south.system.votacao.domain.Pauta;
import br.com.south.system.votacao.entrypoint.filter.PautaFilter;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Validated
@Configuration
@RestController
@RequestMapping("/v1/pauta")
public class PautaController {

    @Autowired
    private PautaUseCase useCase;

    @Autowired
    private PautaFilter filter;

    @ResponseBody
    @PostMapping("/nova")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Cria uma nova pauta")
    public Pauta nova(@RequestParam(name = "nome", required = true) @NotBlank(message = "Nome de pauta é obrigatório!") final String nome) {
        filter.validaNovaPauta(nome);
        return useCase.nova(nome);
    }

    @ResponseBody
    @PutMapping("/abre-sessao")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Abre a sessão de votos de uma pauta")
    public Pauta abreSessao(@RequestParam(name = "id", required = true) @NotBlank(message = "ID da pauta é obrigatório!") final String id,
                                 @RequestParam(name = "data_expiracao", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss") final LocalDateTime dataExpiracao) {
        filter.validaAberturaSessao(id, dataExpiracao);
        return useCase.abreSessao(id, dataExpiracao);
    }

}