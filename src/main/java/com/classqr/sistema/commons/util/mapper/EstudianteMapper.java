package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.CursoDTO;
import com.classqr.sistema.commons.dto.EstudianteDTO;
import com.classqr.sistema.commons.entity.CursoEntity;
import com.classqr.sistema.commons.entity.EstudianteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    EstudianteDTO entityToDto(EstudianteEntity entity);

    EstudianteEntity dtoToEntity(EstudianteDTO dto);

    List<EstudianteDTO> listEntityTolistDto(List<EstudianteEntity> entity);

    List<EstudianteEntity> listDtoToListEntity(List<EstudianteDTO> dto);


}
