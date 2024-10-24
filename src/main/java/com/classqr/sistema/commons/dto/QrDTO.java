package com.classqr.sistema.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class QrDTO {

    private String codigoQr;

    private LocalDateTime fechaCreacionQr;
    private LocalDateTime fechaFinQr;
}
