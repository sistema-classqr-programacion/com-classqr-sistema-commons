package com.classqr.sistema.commons.dto;

import lombok.Data;

@Data
public class EstudianteDTO {

    private Integer id;

    private String nombresEstudiante;

    private String apellidosEstudiante;

    private String numeroDocumento;

    private TipoDocumentoDTO idTipoDocumentoFk;


}
