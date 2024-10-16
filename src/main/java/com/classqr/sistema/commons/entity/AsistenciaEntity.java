package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.InetAddress;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "asistencia", schema = "classqr")
public class AsistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asistencia_id_gen")
    @SequenceGenerator(name = "asistencia_id_gen", sequenceName = "asistencia_codigo_asistencia_seq", allocationSize = 1)
    @Column(name = "codigo_asistencia", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_estudiante_fk", nullable = false)
    private EstudianteEntity codigoEstudianteEntityFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_profesor_fk", nullable = false)
    private ProfesorEntity codigoProfesorEntityFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_curso_fk", nullable = false)
    private CursoEntity codigoCursoEntityFk;

    @Column(name = "ip_estudiante", nullable = false)
    private InetAddress ipEstudiante;

    @Column(name = "fecha_asistencia", nullable = false)
    private LocalDate fechaAsistencia;

}