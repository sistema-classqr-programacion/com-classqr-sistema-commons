package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "curso", schema = "classqr")
public class CursoEntity {
    @Id
    @Column(name = "codigo_curso", nullable = false)
    private String codigoCurso;

    @Column(name = "nombre_curso", nullable = false, length = 100)
    private String nombreCurso;

    @Column(name = "hora_inicio_curso", nullable = false)
    private LocalTime horaInicioCurso;

    @Column(name = "hora_final_curso", nullable = false)
    private LocalTime horaFinalCurso;

}