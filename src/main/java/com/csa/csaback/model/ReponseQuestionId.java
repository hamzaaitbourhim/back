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
public class ReponseQuestionId implements Serializable {
    private static final long serialVersionUID = 2965843036917531823L;
    @Column(name = "ID_QUESTION_EVALUATION", nullable = false)
    private Long idQuestionEvaluation;

    @Column(name = "ID_REPONSE_QUESTION", nullable = false)
    private Long idReponseQuestion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReponseQuestionId entity = (ReponseQuestionId) o;
        return Objects.equals(this.idQuestionEvaluation, entity.idQuestionEvaluation) &&
                Objects.equals(this.idReponseQuestion, entity.idReponseQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionEvaluation, idReponseQuestion);
    }

}