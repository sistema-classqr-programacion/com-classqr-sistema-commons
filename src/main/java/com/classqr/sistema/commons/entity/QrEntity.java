package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "qr", schema = "classqr")
public class QrEntity {

    @Id
    @Column(name = "codigo_qr", nullable = false)
    private String codigoQr;

    @Column(name = "fecha_creacion_qr", nullable = false)
    private LocalDateTime fechaCreacionQr;

    @Column(name = "fecha_fin_qr", nullable = false)
    private LocalDateTime fechaFinQr;

    @Column(name = "imagen_qr", nullable = false)
    private byte[] imagenQr;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigo_curso_fk", nullable = false)
    private CursoEntity cursoFk;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigo_profesor_fk", nullable = false)
    private ProfesorEntity codigoProfesorFk;



}
