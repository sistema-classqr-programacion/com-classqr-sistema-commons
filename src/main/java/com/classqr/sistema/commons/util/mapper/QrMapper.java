package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.ProfesorDTO;
import com.classqr.sistema.commons.dto.QrDTO;
import com.classqr.sistema.commons.entity.ProfesorEntity;
import com.classqr.sistema.commons.entity.QrEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QrMapper {

    QrDTO entityToDto(QrEntity entity);

    QrEntity dtoToEntity(QrDTO dto);

    List<QrDTO> listEntityTolistDto(List<QrEntity> entity);

    List<QrEntity> listDtoToListEntity(List<QrDTO> dto);


}
