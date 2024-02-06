package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "element_constitutif")
public class ElementConstitutif {

    @EmbeddedId
    private ElementConstitutifId id;

    @Column(name = "description", nullable = false, length = 240)
    private String description;

    @Column(name = "designation", nullable = false, length = 64)
    private String designation;

    @Column(name = "nbh_cm")
    private Byte nbhCm;

    @Column(name = "nbh_td")
    private Byte nbhTd;

    @Column(name = "nbh_tp")
    private Byte nbhTp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_enseignant", nullable = false)
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "unite_enseignement_code_ue", nullable = false)
    private UniteEnseignement uniteEnseignement;

}