package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.util.enums.TipoDocumentoEnum;
import lombok.Data;

@Data
public class TipoDocumentoDTO {

    private Integer id;


    private TipoDocumentoEnum nombreTipoDocumento;

}
