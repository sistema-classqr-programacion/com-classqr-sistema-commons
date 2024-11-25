package com.classqr.sistema.commons.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstudianteDTO {

    private String codigoEstudiante;

    private String nombresEstudiante;

    private String apellidosEstudiante;

    private String numeroDocumento;

    private TipoDocumentoDTO idTipoDocumentoEntityFk;

    private Boolean asistio;
}
