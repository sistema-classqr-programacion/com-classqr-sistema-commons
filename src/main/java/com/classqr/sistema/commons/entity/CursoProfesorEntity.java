package com.classqr.sistema.commons.entity;

import com.classqr.sistema.commons.entity.embeddable.CursoProfesorIdEntiy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso_profesor", schema = "classqr")
public class CursoProfesorEntity {
    @EmbeddedId
    private CursoProfesorIdEntiy id;

    @MapsId("codigoCursoFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_curso_fk", nullable = false)
    private CursoEntity codigoCursoEntityFk;

    @MapsId("codigoProfesorFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_profesor_fk", nullable = false)
    private ProfesorEntity codigoProfesorEntityFk;

}