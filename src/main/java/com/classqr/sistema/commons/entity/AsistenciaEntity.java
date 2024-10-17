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
    @Column(name = "codigo_asistencia", nullable = false)
    private String codigoAsistencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_estudiante_fk")
    private EstudianteEntity codigoEstudianteFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_profesor_fk")
    private ProfesorEntity codigoProfesorFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_curso_fk")
    private CursoEntity codigoCursoFk;

    @Column(name = "ip_estudiante")
    private InetAddress ipEstudiante;

    @Column(name = "fecha_asistencia")
    private LocalDate fechaAsistencia;

}