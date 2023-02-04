package br.com.south.system.votacao.model.repository;

import br.com.south.system.votacao.model.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PautaRepository extends JpaRepository<Pauta, Long>{

    Pauta save(final Pauta pauta);

    Optional<Pauta> findById(final String id);

    Optional<Pauta> findByNome(final String nome);
}