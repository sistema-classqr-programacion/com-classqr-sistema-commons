package com.classqr.sistema.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaDTO {

    private String codigoAsistencia;

    private EstudianteDTO codigoEstudianteFk;

    private ProfesorDTO codigoProfesorFk;

    private CursoDTO codigoCursoFk;

    private InetAddress ipEstudiante;

    private LocalDate fechaAsistencia;

}
