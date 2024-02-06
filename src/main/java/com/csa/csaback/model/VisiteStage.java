package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "visite_stage")
public class VisiteStage {
    @EmbeddedId
    private VisiteStageId id;

    @MapsId("id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "annee_pro", referencedColumnName = "ANNEE_PRO", nullable = false),
            @JoinColumn(name = "no_etudiant_nat", referencedColumnName = "NO_ETUDIANT_NAT", nullable = false)
    })
    private Stage stage;

    @Lob
    @Column(name = "commentaire_tuteur_ubo")
    private String commentaireTuteurUbo;

    @Column(name = "date_effective")
    private Instant dateEffective;

    @Column(name = "date_previsionnelle", nullable = false)
    private Instant datePrevisionnelle;

    @Column(name = "duree", length = 20)
    private String duree;

    @Column(name = "heure_effective", length = 20)
    private String heureEffective;

    @Column(name = "heure_previsionnelle", length = 20)
    private String heurePrevisionnelle;

    @Column(name = "type_contact", nullable = false, length = 3)
    private String typeContact;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_contact_ili", nullable = false)
    private Employe noContactIli;

}