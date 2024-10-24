package com.classqr.sistema.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
