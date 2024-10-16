package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.EstudianteDTO;
import com.classqr.sistema.commons.dto.ProfesorDTO;
import com.classqr.sistema.commons.entity.EstudianteEntity;
import com.classqr.sistema.commons.entity.ProfesorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    ProfesorDTO entityToDto(ProfesorEntity entity);

    ProfesorEntity dtoToEntity(ProfesorDTO dto);

    List<ProfesorDTO> listEntityTolistDto(List<ProfesorEntity> entity);

    List<ProfesorEntity> listDtoToListEntity(List<ProfesorDTO> dto);

}
