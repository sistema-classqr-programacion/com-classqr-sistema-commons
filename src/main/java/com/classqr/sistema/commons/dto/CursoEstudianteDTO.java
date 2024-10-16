package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.dto.embeddable.CursoEstudianteIdDTO;
import com.classqr.sistema.commons.entity.CursoEntity;
import com.classqr.sistema.commons.entity.EstudianteEntity;
import lombok.Data;

@Data
public class CursoEstudianteDTO {

    private CursoEstudianteIdDTO id;

    private CursoEntity codigoCursoEntityFk;

    private EstudianteEntity codigoEstudianteEntityFk;


}
