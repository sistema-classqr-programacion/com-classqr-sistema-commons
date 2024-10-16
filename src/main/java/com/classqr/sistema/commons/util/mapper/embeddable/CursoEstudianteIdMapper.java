package com.classqr.sistema.commons.util.mapper.embeddable;

import com.classqr.sistema.commons.dto.CursoEstudianteDTO;
import com.classqr.sistema.commons.dto.TipoDocumentoDTO;
import com.classqr.sistema.commons.dto.embeddable.CursoEstudianteIdDTO;
import com.classqr.sistema.commons.entity.TipoDocumentoEntity;
import com.classqr.sistema.commons.entity.embeddable.CursoEstudianteIdEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoEstudianteIdMapper {

    CursoEstudianteIdDTO entityToDto(CursoEstudianteIdEntity entity);

    CursoEstudianteIdEntity dtoToEntity(CursoEstudianteIdDTO dto);

    List<CursoEstudianteIdDTO> listEntityTolistDto(List<CursoEstudianteIdEntity> entity);

    List<CursoEstudianteIdEntity> listDtoToListEntity(List<CursoEstudianteIdDTO> dto);



}
