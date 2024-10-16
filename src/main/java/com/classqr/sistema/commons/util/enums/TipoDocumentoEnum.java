package com.classqr.sistema.commons.util.enums;

import lombok.Getter;

@Getter
public enum TipoDocumentoEnum {

    CC("CC"),
    TI("TI");

    private final String descripcion;

    TipoDocumentoEnum(String descripcion) {
        this.descripcion = descripcion;
    }

}
