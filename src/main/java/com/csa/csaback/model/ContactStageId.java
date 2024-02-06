package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ContactStageId implements Serializable {
    private static final long serialVersionUID = 624559058139826915L;
    @Column(name = "annee_pro", nullable = false, length = 10)
    private String anneePro;

    @Column(name = "date_contact", nullable = false)
    private Instant dateContact;

    @Column(name = "NO_ETUDIANT_NAT", nullable = false)
    private String noEtudiantNat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ContactStageId entity = (ContactStageId) o;
        return Objects.equals(this.dateContact, entity.dateContact) &&
                Objects.equals(this.noEtudiantNat, entity.noEtudiantNat) &&
                Objects.equals(this.anneePro, entity.anneePro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateContact, noEtudiantNat, anneePro);
    }

}