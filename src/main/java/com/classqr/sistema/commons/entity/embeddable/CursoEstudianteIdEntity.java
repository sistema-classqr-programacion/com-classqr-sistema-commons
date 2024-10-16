package com.classqr.sistema.commons.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CursoEstudianteIdEntity implements java.io.Serializable {
    private static final long serialVersionUID = 6407338206609503963L;
    @Column(name = "codigo_curso_fk", nullable = false)
    private Integer codigoCursoFk;

    @Column(name = "codigo_estudiante_fk", nullable = false)
    private Integer codigoEstudianteFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CursoEstudianteIdEntity entity = (CursoEstudianteIdEntity) o;
        return Objects.equals(this.codigoEstudianteFk, entity.codigoEstudianteFk) &&
                Objects.equals(this.codigoCursoFk, entity.codigoCursoFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoEstudianteFk, codigoCursoFk);
    }

}