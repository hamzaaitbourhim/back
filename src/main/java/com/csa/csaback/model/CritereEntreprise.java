package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "critere_entreprise")
public class CritereEntreprise {
    @Id
    @Column(name = "crite_id", nullable = false)
    private Double id;

    @Lob
    @Column(name = "descriptif")
    private String descriptif;

    @Column(name = "designation", nullable = false, length = 200)
    private String designation;

    @Column(name = "ordre", nullable = false)
    private Double ordre;

    @Column(name = "poids", nullable = false)
    private Double poids;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_evaluation", nullable = false)
    private StructureEvaluation noEvaluation;

}