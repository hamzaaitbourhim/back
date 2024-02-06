package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @Column(name = "no_etudiant_nat", nullable = false, length = 50)
    private String noEtudiantNat;

    @Column(name = "abandon_date")
    private Instant abandonDate;

    @Column(name = "abandon_motif")
    private String abandonMotif;

    @Column(name = "actu_adresse")
    private String actuAdresse;

    @Column(name = "actu_cp", length = 10)
    private String actuCp;

    @Column(name = "actu_pays")
    private String actuPays;

    @Column(name = "actu_ville")
    private String actuVille;

    @Column(name = "code_com", length = 10)
    private String codeCom;

    @Column(name = "compte_cri", nullable = false, length = 10)
    private String compteCri;

    @Column(name = "date_naissance", nullable = false)
    private Instant dateNaissance;

    @Column(name = "dernier_diplome", nullable = false)
    private String dernierDiplome;

    @Column(name = "email")
    private String email;

    @Column(name = "est_diplome")
    private Character estDiplome;

    @Column(name = "grpe_anglais")
    private Byte grpeAnglais;

    @Column(name = "lieu_naissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "nationalite", nullable = false, length = 50)
    private String nationalite;

    @Column(name = "no_etudiant_ubo", length = 20)
    private String noEtudiantUbo;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "perm_adresse", nullable = false)
    private String permAdresse;

    @Column(name = "perm_cp", nullable = false, length = 10)
    private String permCp;

    @Column(name = "perm_pays", nullable = false)
    private String permPays;

    @Column(name = "perm_ville", nullable = false)
    private String permVille;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "sexe", nullable = false, length = 1)
    private String sexe;

    @Column(name = "sigle_etu", nullable = false, length = 3)
    private String sigleEtu;

    @Column(name = "situation", nullable = false, length = 3)
    private String situation;

    @Column(name = "tel_fixe", length = 20)
    private String telFixe;

    @Column(name = "tel_port", length = 20)
    private String telPort;

    @Column(name = "ubo_email")
    private String uboEmail;

    @Column(name = "universite", nullable = false)
    private String universite;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "annee_pro", nullable = false)
    private Promotion promotion;

}