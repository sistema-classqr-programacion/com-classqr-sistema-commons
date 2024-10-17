package com.classqr.sistema.commons.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlackListTokenDTO {

    private Integer id;

    private String token;

    private LocalDateTime fechaExpiracion;

    private String codigoPersona;


}
