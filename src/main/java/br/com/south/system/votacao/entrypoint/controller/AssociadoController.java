package br.com.south.system.votacao.entrypoint.controller;

import br.com.south.system.votacao.application.usecase.AssociadoUseCase;
import br.com.south.system.votacao.domain.Associado;
import br.com.south.system.votacao.entrypoint.filter.AssociadoFilter;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Configuration
@RestController
@RequestMapping("/v1/associado")
public class AssociadoController {

    @Autowired
    private AssociadoUseCase useCase;

    @Autowired
    private AssociadoFilter filter;

    @ResponseBody
    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Cria um novo associado")
    public Associado novo(@RequestParam(name = "cpf", required = true) @NotBlank(message = "CPF é obrigatório!") final String cpf) {
        filter.validaNovoAssociado(cpf);
        return useCase.novo(cpf);
    }
}