package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.AsistenciaDTO;
import com.classqr.sistema.commons.dto.CursoDTO;
import com.classqr.sistema.commons.entity.AsistenciaEntity;
import com.classqr.sistema.commons.entity.CursoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoDTO entityToDto(CursoEntity entity);

    CursoEntity dtoToEntity(CursoDTO dto);

    List<CursoDTO> listEntityTolistDto(List<CursoEntity> entity);

    List<CursoEntity> listDtoToListEntity(List<CursoDTO> dto);

}

