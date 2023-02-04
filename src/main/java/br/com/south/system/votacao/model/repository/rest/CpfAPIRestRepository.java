package br.com.south.system.votacao.model.repository.rest;

import br.com.south.system.votacao.controller.dto.ResponseCpfApiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cpfApi", url = "${url.api.cpf}")
public interface CpfAPIRestRepository {

    @GetMapping("/users/{cpf}")
    ResponseCpfApiDTO validaCpf(@PathVariable("cpf") final String cpf);
}