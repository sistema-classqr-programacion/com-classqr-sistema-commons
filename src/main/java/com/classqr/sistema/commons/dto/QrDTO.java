package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.entity.CursoEntity;
import com.classqr.sistema.commons.entity.ProfesorEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrDTO {

    private String codigoQr;

    private LocalDateTime fechaCreacionQr;

    private LocalDateTime fechaFinQr;

    private byte[] imagenQr;

    private CursoDTO cursoFk;

    private ProfesorDTO codigoProfesorFk;

}
