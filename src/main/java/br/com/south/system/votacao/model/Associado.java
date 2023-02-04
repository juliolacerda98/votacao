package br.com.south.system.votacao.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "associado")
public class Associado {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(unique = true)
    private String cpf;

    @JsonManagedReference
    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
    private List<Voto> votos = new ArrayList<>();

    public Associado(String cpf) {
        this.cpf = cpf;
    }
}