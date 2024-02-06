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
@Table(name = "notation_stage")
public class NotationStage {
    @Id
    @Column(name = "no_bareme", nullable = false)
    private Double noBareme;

    @Column(name = "coeff_ent", nullable = false)
    private Double coeffEnt;

    @Column(name = "coeff_rapport", nullable = false)
    private Double coeffRapport;

    @Column(name = "coeff_soutenance", nullable = false)
    private Double coeffSoutenance;

    @Column(name = "date_creation", nullable = false)
    private Instant dateCreation;

    @Column(name = "etat_bareme", nullable = false, length = 3)
    private String etatBareme;

}