package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reponse_evaluation")
public class ReponseEvaluation {
    @Id
    @Column(name = "id_reponse_evaluation", nullable = false)
    private Long id;

    @Column(name = "commentaire", length = 512)
    private String commentaire;

    @Column(name = "nom", length = 32)
    private String nom;

    @Column(name = "prenom", length = 32)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation idEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_etudiant_nat")
    private Etudiant noEtudiantNat;

}