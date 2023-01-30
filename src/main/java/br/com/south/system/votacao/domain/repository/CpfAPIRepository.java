package br.com.south.system.votacao.domain.repository;

import br.com.south.system.votacao.entrypoint.dto.ResponseCpfApiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cpfApi", url = "${url.api.cpf}")
public interface CpfAPIRepository {

    @GetMapping("/users/{cpf}")
    ResponseCpfApiDTO validaCpf(@PathVariable("cpf") final String cpf);
}