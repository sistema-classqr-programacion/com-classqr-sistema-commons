package com.classqr.sistema.commons.util.enums;

import lombok.Getter;

@Getter
public enum CodigoUsuarioEnum {

    ESTUDIANTE("E"),
    PROFESOR("P"),
    ASISTENCIA("A");

    private final String descripcion;

    CodigoUsuarioEnum(String descripcion) {
        this.descripcion = descripcion;
    }

}
