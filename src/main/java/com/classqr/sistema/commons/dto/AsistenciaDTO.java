package com.classqr.sistema.commons.dto;

import lombok.Data;

import java.net.InetAddress;
import java.time.LocalDate;

@Data
public class AsistenciaDTO {

    private Integer id;

    private EstudianteDTO codigoEstudianteFk;

    private ProfesorDTO codigoProfesorFk;

    private CursoDTO codigoCursoFk;

    private InetAddress ipEstudiante;

    private LocalDate fechaAsistencia;

}
