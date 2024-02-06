package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @Column(name = "annee_pro", nullable = false, length = 10)
    private String anneePro;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "date_rentree")
    private Instant dateRentree;

    @Column(name = "date_reponse_lalp")
    private Instant dateReponseLalp;

    @Column(name = "date_reponse_lp")
    private Instant dateReponseLp;

    @Column(name = "etat_preselection", nullable = false, length = 3)
    private String etatPreselection;

    @Column(name = "lieu_rentree")
    private String lieuRentree;

    @Column(name = "nb_etu_souhaite", nullable = false)
    private Short nbEtuSouhaite;

    @Column(name = "processus_stage", length = 5)
    private String processusStage;

    @Column(name = "sigle_pro", nullable = false, length = 5)
    private String siglePro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "code_formation")
    private Formation formation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "no_bareme")
    private NotationStage notationStage;

    @ManyToOne(fetch = FetchType.EAGER) //, cascade = CascadeType.ALL
    @JoinColumn(name = "no_enseignant")
    private Enseignant enseignant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "no_evaluation")
    private StructureEvaluation structureEvaluation;

}