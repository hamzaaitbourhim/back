package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "avenant")
public class Avenant {
    @Id
    @Column(name = "no_avenant", nullable = false)
    private Integer id;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "date_signature_ave")
    private Instant dateSignatureAve;

    @Column(name = "etat_avenant", nullable = false)
    private String etatAvenant;

    @Column(name = "modif_apportee", nullable = false)
    private String modifApportee;

    @Column(name = "num_article", nullable = false)
    private Integer numArticle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "annee_pro", referencedColumnName = "ANNEE_PRO", nullable = false),
            @JoinColumn(name = "no_etudiant_nat", referencedColumnName = "NO_ETUDIANT_NAT", nullable = false)
    })
    private Stage stage;

}