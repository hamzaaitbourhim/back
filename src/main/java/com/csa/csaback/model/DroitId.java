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
public class DroitId implements Serializable {
    private static final long serialVersionUID = -804850090725681454L;
    @Column(name = "ID_EVALUATION", nullable = false)
    private Long idEvaluation;

    @Column(name = "NO_ENSEIGNANT", nullable = false)
    private Integer noEnseignant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DroitId entity = (DroitId) o;
        return Objects.equals(this.idEvaluation, entity.idEvaluation) &&
                Objects.equals(this.noEnseignant, entity.noEnseignant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvaluation, noEnseignant);
    }

}