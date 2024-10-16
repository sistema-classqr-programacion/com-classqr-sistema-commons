package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.AsistenciaDTO;
import com.classqr.sistema.commons.entity.AsistenciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    AsistenciaDTO entityToDto(AsistenciaEntity entity);

    AsistenciaEntity dtoToEntity(AsistenciaDTO dto);

    List<AsistenciaDTO> listEntityTolistDto(List<AsistenciaEntity> entity);

    List<AsistenciaEntity> listDtoToListEntity(List<AsistenciaDTO> dto);



}
