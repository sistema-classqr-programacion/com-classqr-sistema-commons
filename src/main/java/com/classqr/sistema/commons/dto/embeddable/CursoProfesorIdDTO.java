package com.classqr.sistema.commons.dto.embeddable;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CursoProfesorIdDTO {

    private String codigoCursoFk;

    private String codigoProfesorFk;

}
