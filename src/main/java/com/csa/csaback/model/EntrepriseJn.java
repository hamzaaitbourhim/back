package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "entreprise_jn")
public class EntrepriseJn {
    @Id
    @Column(name = "login_maj", nullable = false, length = 8)
    private String loginMaj;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "cp", length = 10)
    private String cp;

    @Column(name = "date_crea")
    private Instant dateCrea;

    @Column(name = "date_maj")
    private Instant dateMaj;

    @Column(name = "date_referencement")
    private Instant dateReferencement;

    @Column(name = "domaine_activite", length = 5)
    private String domaineActivite;

    @Column(name = "jn_appln", length = 35)
    private String jnAppln;

    @Column(name = "jn_datetime", nullable = false)
    private Instant jnDatetime;

    @Column(name = "jn_notes", length = 240)
    private String jnNotes;

    @Column(name = "jn_operation", nullable = false, length = 3)
    private String jnOperation;

    @Column(name = "jn_oracle_user", nullable = false, length = 30)
    private String jnOracleUser;

    @Column(name = "jn_session", precision = 38)
    private BigDecimal jnSession;

    @Column(name = "login_crea", length = 8)
    private String loginCrea;

    @Column(name = "no_entreprise", nullable = false)
    private Double noEntreprise;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "nom_representant", length = 50)
    private String nomRepresentant;

    @Column(name = "offre_stage")
    private Character offreStage;

    @Column(name = "pays", length = 100)
    private String pays;

    @Column(name = "prenom_representant", length = 50)
    private String prenomRepresentant;

    @Column(name = "referencee")
    private Character referencee;

    @Column(name = "siege_social", length = 100)
    private String siegeSocial;

    @Column(name = "site_internet", length = 150)
    private String siteInternet;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "ville", length = 100)
    private String ville;

}