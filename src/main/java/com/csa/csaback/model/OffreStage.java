package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "offre_stage")
public class OffreStage {
    @Id
    @Column(name = "no_offre", nullable = false)
    private Double id;

    @Column(name = "date_creation", nullable = false)
    private Instant dateCreation;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "duree", nullable = false, length = 30)
    private String duree;

    @Column(name = "etat_offre", nullable = false, length = 3)
    private String etatOffre;

    @Column(name = "intitule", nullable = false, length = 100)
    private String intitule;

    @Column(name = "lieu", nullable = false, length = 80)
    private String lieu;

    @Column(name = "mail_responsable", length = 100)
    private String mailResponsable;

    @Column(name = "niveau_requis", nullable = false, length = 5)
    private String niveauRequis;

    @Column(name = "no_offre_entreprise", length = 20)
    private String noOffreEntreprise;

    @Column(name = "nom_responsable", nullable = false, length = 50)
    private String nomResponsable;

    @Column(name = "periode", nullable = false, length = 50)
    private String periode;

    @Column(name = "prenom_responsable", nullable = false, length = 50)
    private String prenomResponsable;

    @Column(name = "remuneration", length = 20)
    private String remuneration;

    @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "tel_responsable", length = 20)
    private String telResponsable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "annee_pro", nullable = false)
    private Promotion anneePro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_entreprise", nullable = false)
    private Entreprise noEntreprise;

}