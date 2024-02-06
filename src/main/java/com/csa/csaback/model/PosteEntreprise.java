package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "poste_entreprise")
public class PosteEntreprise {
    @EmbeddedId
    private PosteEntrepriseId id;

    @MapsId("noEntreprise")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NO_ENTREPRISE", nullable = false)
    private Entreprise noEntreprise;

    @MapsId("noEtudiantNat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NO_ETUDIANT_NAT", nullable = false)
    private Diplome noEtudiantNat;

    @Column(name = "brut_annuel")
    private Integer brutAnnuel;

    @Column(name = "date_embauche", nullable = false)
    private Instant dateEmbauche;

    @Column(name = "fonction", nullable = false, length = 5)
    private String fonction;

    @Column(name = "moyen_obtention", nullable = false, length = 3)
    private String moyenObtention;

    @Column(name = "service", length = 5)
    private String service;

}