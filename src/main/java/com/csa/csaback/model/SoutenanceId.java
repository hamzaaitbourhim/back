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
public class SoutenanceId implements Serializable {
    private static final long serialVersionUID = 934142972387850979L;
    @Column(name = "no_session", nullable = false)
    private Double noSession;

    @Column(name = "ANNEE_PRO", nullable = false)
    private String anneePro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SoutenanceId entity = (SoutenanceId) o;
        return Objects.equals(this.noSession, entity.noSession) &&
                Objects.equals(this.anneePro, entity.anneePro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noSession, anneePro);
    }

}