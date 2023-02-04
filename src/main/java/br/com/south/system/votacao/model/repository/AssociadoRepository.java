package br.com.south.system.votacao.model.repository;

import br.com.south.system.votacao.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Associado save(final Associado Associado);

    Optional<Associado> findById(final String id);

    Optional<Associado> findByCpf(final String cpf);
}