package br.com.south.system.votacao.model;

import br.com.south.system.votacao.model.enumerated.TipoVoto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "voto")
public class Voto {

    @Id
    private String id = UUID.randomUUID().toString();

    @JsonProperty("tipo_voto")
    @Column(name = "tipo_voto")
    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "associado_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Associado associado;

    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "pauta_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Pauta pauta;


    public Voto(TipoVoto tipoVoto, Associado associado, Pauta pauta) {
        this.tipoVoto = tipoVoto;
        this.associado = associado;
        this.pauta = pauta;
    }
}