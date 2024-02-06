package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @Column(name = "code_formation", nullable = false, length = 8)
    private String codeFormation;

    @Column(name = "debut_habilitation")
    private Instant debutHabilitation;

    @Column(name = "diplome", nullable = false, length = 3)
    private String diplome;

    @Column(name = "double_diplome", nullable = false)
    private Character doubleDiplome;

    @Column(name = "fin_habilitation")
    private Instant finHabilitation;

    @Column(name = "n0_annee", nullable = false)
    private Byte n0Annee;

    @Column(name = "nom_formation", nullable = false, length = 64)
    private String nomFormation;

}