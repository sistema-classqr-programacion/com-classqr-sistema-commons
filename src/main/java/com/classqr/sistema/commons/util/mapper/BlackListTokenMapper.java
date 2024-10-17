package com.classqr.sistema.commons.util.mapper;

import com.classqr.sistema.commons.dto.BlackListTokenDTO;
import com.classqr.sistema.commons.entity.BlackListTokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlackListTokenMapper {


    BlackListTokenDTO entityToDto(BlackListTokenEntity entity);

    BlackListTokenEntity dtoToEntity(BlackListTokenDTO dto);

    List<BlackListTokenDTO> listEntityTolistDto(List<BlackListTokenEntity> entity);

    List<BlackListTokenEntity> listDtoToListEntity(List<BlackListTokenDTO> dto);


}
