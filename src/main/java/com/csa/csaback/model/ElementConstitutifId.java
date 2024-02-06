package com.csa.csaback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ElementConstitutifId implements Serializable {
    private static final long serialVersionUID = 6303165433300821764L;
    @Column(name = "code_ec", nullable = false, length = 8)
    private String codeEc;

    @Column(name = "code_formation", nullable = false, length = 8)
    private String codeFormation;

    @Column(name = "code_ue", nullable = false, length = 8)
    private String codeUe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ElementConstitutifId entity = (ElementConstitutifId) o;
        return Objects.equals(this.codeEc, entity.codeEc) &&
                Objects.equals(this.codeUe, entity.codeUe) &&
                Objects.equals(this.codeFormation, entity.codeFormation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeEc, codeUe, codeFormation);
    }

}