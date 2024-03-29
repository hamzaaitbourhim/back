package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StageId implements Serializable {
    private static final long serialVersionUID = 2927503023222766018L;
    @Column(name = "ANNEE_PRO", nullable = false)
    private String anneePro;

    @Column(name = "NO_ETUDIANT_NAT", nullable = false)
    private String noEtudiantNat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StageId entity = (StageId) o;
        return Objects.equals(this.noEtudiantNat, entity.noEtudiantNat) &&
                Objects.equals(this.anneePro, entity.anneePro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noEtudiantNat, anneePro);
    }

}