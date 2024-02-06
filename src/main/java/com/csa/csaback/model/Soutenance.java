package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "soutenance")
public class Soutenance {
    @EmbeddedId
    private SoutenanceId id;

    @MapsId("anneePro")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ANNEE_PRO", nullable = false)
    private Promotion anneePro;

    @Column(name = "date_soutenance", nullable = false)
    private Instant dateSoutenance;

    @Column(name = "plage_horaire", nullable = false, length = 50)
    private String plageHoraire;

    @Column(name = "salle", nullable = false, length = 12)
    private String salle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_enseignant_assesseur", nullable = false)
    private Enseignant noEnseignantAssesseur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_enseignant_responsable", nullable = false)
    private Enseignant noEnseignantResponsable;

}