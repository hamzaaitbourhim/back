package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "diplome")
public class Diplome {

    @Id
    @Column(name = "no_etudiant_nat", nullable = false, length = 50)
    private String noEtudiantNat;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "no_etudiant_nat", nullable = false)
    private Etudiant etudiant;

    @Column(name = "adresse", length = 100)
    private String adresse;

    @Column(name = "autorisation_annuaire", nullable = false)
    private Character autorisationAnnuaire;

    @Column(name = "cp", length = 10)
    private String cp;

    @Column(name = "email_perso", length = 100)
    private String emailPerso;

    @Column(name = "mail_pro", length = 100)
    private String mailPro;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "portable", length = 20)
    private String portable;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "tel_perso", length = 20)
    private String telPerso;

    @Column(name = "tel_pro", length = 20)
    private String telPro;

    @Column(name = "type_emploi", length = 3)
    private String typeEmploi;

    @Column(name = "ville", length = 50)
    private String ville;

}