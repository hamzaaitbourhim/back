package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rubrique")
public class Rubrique {
    @Id
    @Column(name = "id_rubrique", nullable = false)
    private Long id;

    @Column(name = "designation", nullable = false, length = 32)
    private String designation;

    @Column(name = "ordre")
    private Double ordre;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

}