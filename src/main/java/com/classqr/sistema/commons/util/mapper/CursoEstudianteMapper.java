package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.AsistenciaDTO;
import com.classqr.sistema.commons.dto.CursoEstudianteDTO;
import com.classqr.sistema.commons.entity.AsistenciaEntity;
import com.classqr.sistema.commons.entity.CursoEstudianteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoEstudianteMapper {

    CursoEstudianteDTO entityToDto(CursoEstudianteEntity entity);

    CursoEstudianteEntity dtoToEntity(CursoEstudianteDTO dto);

    List<CursoEstudianteDTO> listEntityTolistDto(List<CursoEstudianteEntity> entity);

    List<CursoEstudianteEntity> listDtoToListEntity(List<CursoEstudianteDTO> dto);


}
