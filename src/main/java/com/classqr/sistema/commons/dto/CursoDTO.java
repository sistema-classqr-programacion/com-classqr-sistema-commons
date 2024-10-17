package com.classqr.sistema.commons.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
public class CursoDTO {

    private String codigoCurso;

    private String nombreCurso;

    private LocalTime horaInicioCurso;

    private LocalTime horaFinalCurso;

}
