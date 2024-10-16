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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_id_gen")
    @SequenceGenerator(name = "curso_id_gen", sequenceName = "curso_codigo_curso_seq", allocationSize = 1)
    @Column(name = "codigo_curso", nullable = false)
    private Integer id;

    @Column(name = "nombre_curso", nullable = false, length = 100)
    private String nombreCurso;

    @Column(name = "hora_inicio_curso", nullable = false)
    private LocalTime horaInicioCurso;

    @Column(name = "hora_final_curso", nullable = false)
    private LocalTime horaFinalCurso;

}