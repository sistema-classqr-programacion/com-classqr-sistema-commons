package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.CursoDTO;
import com.classqr.sistema.commons.dto.CursoProfesorDTO;
import com.classqr.sistema.commons.entity.CursoEntity;
import com.classqr.sistema.commons.entity.CursoProfesorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoProfesorMapper {

    CursoProfesorDTO entityToDto(CursoProfesorEntity entity);

    CursoProfesorEntity dtoToEntity(CursoProfesorDTO dto);

    List<CursoProfesorDTO> listEntityTolistDto(List<CursoProfesorEntity> entity);

    List<CursoProfesorEntity> listDtoToListEntity(List<CursoProfesorDTO> dto);


}
