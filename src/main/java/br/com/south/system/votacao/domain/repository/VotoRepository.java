package br.com.south.system.votacao.domain.repository;

import br.com.south.system.votacao.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Long>, JpaSpecificationExecutor<Voto> {

    Voto save(final Voto Voto);

    Optional<Voto> findById(final String id);

    @Query("SELECT v FROM Voto v WHERE v.associado.id = ?1 AND v.pauta.id = ?2")
    Optional<Voto> findByAssociadoAndPauta(final String associadoId, final String pautaId);
}