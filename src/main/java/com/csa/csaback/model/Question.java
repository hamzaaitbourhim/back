package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id_question", nullable = false)
    private Long id;

    @Column(name = "`intitulֹ`", nullable = false, length = 64)
    private String intitulֹ;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_qualificatif", nullable = false)
    private Qualificatif idQualificatif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

}