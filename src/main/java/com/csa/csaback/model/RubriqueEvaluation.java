package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubrique_evaluation")
public class RubriqueEvaluation {
    @Id
    @Column(name = "id_rubrique_evaluation", nullable = false)
    private Long id;

    @Column(name = "designation", length = 64)
    private String designation;

    @Column(name = "ordre", nullable = false)
    private Byte ordre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation idEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rubrique")
    private Rubrique idRubrique;

}