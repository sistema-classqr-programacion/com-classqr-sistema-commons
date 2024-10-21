package com.classqr.sistema.commons.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfesorDTO {

    private String codigoProfesor;

    private String nombresProfesor;

    private String apellidosProfesor;

    private String numeroDocumento;

    private String correoProfesor;

    private String passwordProfesor;

    private TipoDocumentoDTO idTipoDocumentoEntityFk;

}
