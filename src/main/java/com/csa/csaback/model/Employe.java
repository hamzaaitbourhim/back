package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employe")
public class Employe {
    @Id
    @Column(name = "no_contact_ili", nullable = false)
    private Double NoContactIli;

    @Column(name = "fonction", length = 5)
    private String fonction;

    @Column(name = "mail_pro", length = 100)
    private String mailPro;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "tel_pro", length = 20)
    private String telPro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_entreprise", nullable = false)
    private Entreprise entreprise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_etudiant_nat")
    private Diplome diplome;

}