package com.classqr.sistema.commons.entity;

import com.classqr.sistema.commons.entity.embeddable.CursoEstudianteIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso_estudiante", schema = "classqr")
public class CursoEstudianteEntity {
    @SequenceGenerator(name = "curso_estudiante_id_gen", sequenceName = "curso_codigo_curso_seq", allocationSize = 1)
    @EmbeddedId
    private CursoEstudianteIdEntity id;

    @MapsId("codigoCursoFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_curso_fk", nullable = false)
    private CursoEntity codigoCursoEntityFk;

    @MapsId("codigoEstudianteFk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_estudiante_fk", nullable = false)
    private EstudianteEntity codigoEstudianteEntityFk;

}