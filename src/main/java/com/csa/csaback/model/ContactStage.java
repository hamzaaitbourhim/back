package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contact_stage")
public class ContactStage {
    @EmbeddedId
    private ContactStageId id;

    @MapsId("noEtudiantNat")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NO_ETUDIANT_NAT", nullable = false)
    private Etudiant noEtudiantNat;

    @Column(name = "duree", length = 20)
    private String duree;

    @Column(name = "heure_contact", length = 20)
    private String heureContact;

    @Column(name = "interlocuteur", length = 3)
    private String interlocuteur;

    @Column(name = "objet", nullable = false)
    private String objet;

    @Lob
    @Column(name = "resume")
    private String resume;

    @Column(name = "type_contact", nullable = false, length = 3)
    private String typeContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_contact_ili")
    private Employe noContactIli;

}