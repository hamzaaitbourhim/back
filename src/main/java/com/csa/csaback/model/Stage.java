package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "stage")
public class Stage {
    @EmbeddedId
    private StageId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "ANNEE_PRO", referencedColumnName = "ANNEE_PRO", nullable = false),
            @JoinColumn(name = "no_session", referencedColumnName = "no_session", nullable = false)
    })
    private Soutenance soutenance;

    @MapsId("noEtudiantNat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NO_ETUDIANT_NAT", nullable = false)
    private Etudiant noEtudiantNat;

    @Column(name = "commentaire_tuteur")
    private String commentaireTuteur;

    @Column(name = "date_deb", nullable = false)
    private Instant dateDeb;

    @Column(name = "date_fin", nullable = false)
    private Instant dateFin;

    @Column(name = "date_reception_rapport")
    private Instant dateReceptionRapport;

    @Column(name = "date_signature_conv")
    private Instant dateSignatureConv;

    @Column(name = "description", length = 4000)
    private String description;

    @Column(name = "etat_convention", length = 3)
    private String etatConvention;

    @Column(name = "etat_stage", nullable = false, length = 3)
    private String etatStage;

    @Column(name = "intitule", nullable = false, length = 200)
    private String intitule;

    @Column(name = "lieu", nullable = false, length = 50)
    private String lieu;

    @Column(name = "note_entreprise")
    private Double noteEntreprise;

    @Column(name = "note_rapport")
    private Double noteRapport;

    @Column(name = "note_soutenance")
    private Double noteSoutenance;

    @Column(name = "sujet", nullable = false, length = 200)
    private String sujet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_contact_ili", nullable = false)
    private Employe noContactIli;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_enseignant")
    private Enseignant noEnseignant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_entreprise", nullable = false)
    private Entreprise noEntreprise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_offre")
    private OffreStage noOffre;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "no_session", nullable = true)
    @Column(name = "no_session")
    private Double noSession;

}