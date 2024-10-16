package com.classqr.sistema.commons.util.mapper.embeddable;

import com.classqr.sistema.commons.dto.embeddable.CursoEstudianteIdDTO;
import com.classqr.sistema.commons.dto.embeddable.CursoProfesorIdDTO;
import com.classqr.sistema.commons.entity.embeddable.CursoEstudianteIdEntity;
import com.classqr.sistema.commons.entity.embeddable.CursoProfesorIdEntiy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoProfesorIdMapper {

    CursoProfesorIdDTO entityToDto(CursoProfesorIdEntiy entity);

    CursoProfesorIdEntiy dtoToEntity(CursoProfesorIdDTO dto);

    List<CursoProfesorIdDTO> listEntityTolistDto(List<CursoProfesorIdEntiy> entity);

    List<CursoProfesorIdEntiy> listDtoToListEntity(List<CursoProfesorIdDTO> dto);



}
