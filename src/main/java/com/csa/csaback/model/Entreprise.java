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
@Table(name = "entreprise")
public class Entreprise {
    @Id
    @Column(name = "no_entreprise", nullable = false)
    private Double noEntreprise;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "cp", nullable = false, length = 10)
    private String cp;

    @Column(name = "date_crea", nullable = false)
    private Instant dateCrea;

    @Column(name = "date_maj")
    private Instant dateMaj;

    @Column(name = "date_referencement")
    private Instant dateReferencement;

    @Column(name = "domaine_activite", nullable = false, length = 5)
    private String domaineActivite;

    @Column(name = "login_crea", length = 8)
    private String loginCrea;

    @Column(name = "login_maj", length = 8)
    private String loginMaj;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "nom_representant", length = 50)
    private String nomRepresentant;

    @Column(name = "offre_stage")
    private Character offreStage;

    @Column(name = "pays", nullable = false, length = 100)
    private String pays;

    @Column(name = "prenom_representant", length = 50)
    private String prenomRepresentant;

    @Column(name = "referencee")
    private Character referencee;

    @Column(name = "siege_social", nullable = false, length = 100)
    private String siegeSocial;

    @Column(name = "site_internet", length = 150)
    private String siteInternet;

    @Column(name = "tel", nullable = false, length = 20)
    private String tel;

    @Column(name = "ville", nullable = false, length = 100)
    private String ville;

}