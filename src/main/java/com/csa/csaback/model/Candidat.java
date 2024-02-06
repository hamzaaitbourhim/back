package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "candidat")
public class Candidat {
    @Id
    @Column(name = "no_etudiant_nat", nullable = false, length = 50)
    private String noEtudiantNat;

    @Column(name = "actu_adresse")
    private String actuAdresse;

    @Column(name = "actu_cp", length = 10)
    private String actuCp;

    @Column(name = "actu_pays")
    private String actuPays;

    @Column(name = "actu_ville")
    private String actuVille;

    @Column(name = "date_naissance", nullable = false)
    private Instant dateNaissance;

    @Column(name = "date_reponse_can")
    private Instant dateReponseCan;

    @Column(name = "date_reponse_ili")
    private Instant dateReponseIli;

    @Column(name = "dernier_diplome", nullable = false)
    private String dernierDiplome;

    @Column(name = "email")
    private String email;

    @Column(name = "lieu_naissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "nationalite", nullable = false, length = 50)
    private String nationalite;

    @Column(name = "no_ordre")
    private Double noOrdre;

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

    @Column(name = "reponse_can", length = 3)
    private String reponseCan;

    @Column(name = "reponse_ili", nullable = false)
    private Character reponseIli;

    @Column(name = "selection_courante", nullable = false, length = 2)
    private String selectionCourante;

    @Column(name = "selection_origine", nullable = false, length = 2)
    private String selectionOrigine;

    @Column(name = "sexe", nullable = false)
    private Character sexe;

    @Column(name = "situation", nullable = false, length = 3)
    private String situation;

    @Column(name = "tel_fixe", length = 20)
    private String telFixe;

    @Column(name = "tel_port", length = 20)
    private String telPort;

    @Column(name = "universite", nullable = false)
    private String universite;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "annee_pro", nullable = false)
    private Promotion promotion;

}