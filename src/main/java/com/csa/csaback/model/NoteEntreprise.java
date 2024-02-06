package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "note_entreprise")
public class NoteEntreprise {
    @EmbeddedId
    private NoteEntrepriseId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "annee_pro", referencedColumnName = "annee_pro", nullable = false),
            @JoinColumn(name = "no_etudiant_nat", referencedColumnName = "no_etudiant_nat", nullable = false)
    })
    private EvaluationEntreprise evaluationEntreprise;

    @MapsId("criteId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CRITE_ID", nullable = false)
    private CritereEntreprise crite;

    @Lob
    @Column(name = "commentaire")
    private String commentaire;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codn_id", nullable = false)
    private CodeNotation codn;

}