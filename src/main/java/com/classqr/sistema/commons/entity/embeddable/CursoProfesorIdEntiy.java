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
public class CursoProfesorIdEntiy implements java.io.Serializable {
    private static final long serialVersionUID = -6730613326699073487L;
    @Column(name = "codigo_curso_fk", nullable = false)
    private String codigoCursoFk;

    @Column(name = "codigo_profesor_fk", nullable = false)
    private String codigoProfesorFk;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CursoProfesorIdEntiy entity = (CursoProfesorIdEntiy) o;
        return Objects.equals(this.codigoProfesorFk, entity.codigoProfesorFk) &&
                Objects.equals(this.codigoCursoFk, entity.codigoCursoFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProfesorFk, codigoCursoFk);
    }

}