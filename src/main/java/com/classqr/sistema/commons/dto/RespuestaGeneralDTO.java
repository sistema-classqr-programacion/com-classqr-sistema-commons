package com.classqr.sistema.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaGeneralDTO implements Serializable {

    private String status;

    private Object data;

    private String message;

}

