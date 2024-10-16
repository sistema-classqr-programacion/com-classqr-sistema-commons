package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.ProfesorDTO;
import com.classqr.sistema.commons.dto.TipoDocumentoDTO;
import com.classqr.sistema.commons.entity.ProfesorEntity;
import com.classqr.sistema.commons.entity.TipoDocumentoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapper {

    TipoDocumentoDTO entityToDto(TipoDocumentoEntity entity);

    TipoDocumentoEntity dtoToEntity(TipoDocumentoDTO dto);

    List<TipoDocumentoDTO> listEntityTolistDto(List<TipoDocumentoEntity> entity);

    List<TipoDocumentoEntity> listDtoToListEntity(List<TipoDocumentoDTO> dto);


}
