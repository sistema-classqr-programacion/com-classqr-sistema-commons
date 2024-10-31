package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.AsistenciaDTO;
import com.classqr.sistema.commons.entity.AsistenciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsistenciaMapper {

    AsistenciaDTO entityToDto(AsistenciaEntity entity);

    AsistenciaEntity dtoToEntity(AsistenciaDTO dto);

    List<AsistenciaDTO> listEntityToListDto(List<AsistenciaEntity> entity);

    List<AsistenciaEntity> listDtoToListEntity(List<AsistenciaDTO> dto);

    default Page<AsistenciaDTO> pageEntityToPageDto(Page<AsistenciaEntity> entities) {
        List<AsistenciaDTO> dtos = listEntityToListDto(entities.getContent());
        return new PageImpl<>(dtos, entities.getPageable(), entities.getTotalElements());
    }

    default Page<AsistenciaEntity> pageDtoToPageEntity(Page<AsistenciaDTO> dtos) {
        List<AsistenciaEntity> entities = listDtoToListEntity(dtos.getContent());
        return new PageImpl<>(entities, dtos.getPageable(), dtos.getTotalElements());
    }

}
