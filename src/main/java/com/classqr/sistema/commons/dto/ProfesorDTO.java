package com.classqr.sistema.commons.dto;

import lombok.Data;

@Data
public class ProfesorDTO {

    private String codigoProfesor;

    private String nombresProfesor;

    private String apellidosProfesor;

    private String numeroDocumento;

    private TipoDocumentoDTO idTipoDocumentoFk;

}
