package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "evaluation_entreprise")
public class EvaluationEntreprise {
    @EmbeddedId
    private EvaluationEntrepriseId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "annee_pro", referencedColumnName = "ANNEE_PRO", nullable = false),
            @JoinColumn(name = "no_etudiant_nat", referencedColumnName = "NO_ETUDIANT_NAT", nullable = false)
    })
    private Stage stage;

    @Column(name = "date_maj", nullable = false)
    private Instant dateMaj;

    @Column(name = "etat", nullable = false, length = 3)
    private String etat;

}