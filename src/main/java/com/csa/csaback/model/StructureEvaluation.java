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
@Table(name = "structure_evaluation")
public class StructureEvaluation {
    @Id
    @Column(name = "no_evaluation", nullable = false)
    private Double noEvaluation;

    @Column(name = "date_creation", nullable = false)
    private Instant dateCreation;

    @Column(name = "etat", nullable = false, length = 3)
    private String etat;

}