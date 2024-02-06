package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "unite_enseignement")
public class UniteEnseignement {
    @Id
    @Column(name = "code_ue", nullable = false, length = 8)
    private String codeUe;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "designation", nullable = false, length = 64)
    private String designation;

    @Column(name = "nbh_cm", precision = 38)
    private BigDecimal nbhCm;

    @Column(name = "nbh_td")
    private Byte nbhTd;

    @Column(name = "nbh_tp")
    private Byte nbhTp;

    @Column(name = "semestre", nullable = false, length = 3)
    private String semestre;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "code_formation", nullable = false)
    private Formation formation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_enseignant", nullable = false)
    private Enseignant enseignant;

}