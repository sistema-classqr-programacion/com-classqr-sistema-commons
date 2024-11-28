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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asistencia_id_asistencia_gen")
    @SequenceGenerator(name = "asistencia_id_asistencia_gen", sequenceName = "asistencia_id_asistencia_seq", allocationSize = 1)
    @Column(name = "id_asistencia")
    private Long idAsistencia;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_qr_fk")
    private QrEntity codigoQrFk;

    @Column(name = "ip_estudiante")
    private InetAddress ipEstudiante;

    @Column(name = "fecha_asistencia")
    private LocalDate fechaAsistencia;

}