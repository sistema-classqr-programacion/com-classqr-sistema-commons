package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.dto.embeddable.CursoProfesorIdDTO;
import lombok.Data;

@Data
public class CursoProfesorDTO {

    private CursoProfesorIdDTO id;

    private CursoDTO codigoCursoFk;

    private ProfesorDTO codigoProfesorFk;

}
