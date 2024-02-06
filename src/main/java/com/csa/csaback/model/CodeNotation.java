package com.csa.csaback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "code_notation")
public class CodeNotation {
    @Id
    @Column(name = "codn_id", nullable = false)
    private Double id;

    @Column(name = "code_note", nullable = false, length = 3)
    private String codeNote;

    @Lob
    @Column(name = "descriptif")
    private String descriptif;

    @Column(name = "designation", nullable = false, length = 50)
    private String designation;

    @Column(name = "valeur_note", nullable = false)
    private Double valeurNote;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "no_bareme", nullable = false)
    private NotationStage noBareme;

}