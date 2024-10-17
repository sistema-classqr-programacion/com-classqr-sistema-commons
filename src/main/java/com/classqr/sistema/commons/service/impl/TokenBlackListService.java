package com.classqr.sistema.commons.service.impl;

import com.classqr.sistema.commons.dto.BlackListTokenDTO;
import com.classqr.sistema.commons.repository.BlackListTokenRepository;
import com.classqr.sistema.commons.service.ITokenBlackListService;
import com.classqr.sistema.commons.util.helper.Utilidades;
import com.classqr.sistema.commons.util.mapper.BlackListTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenBlackListService implements ITokenBlackListService {

    private final BlackListTokenRepository blackListTokenRepository;

    private final BlackListTokenMapper blackListTokenMapper;

    private final JwtService jwtService;

    @Override
    @Transactional
    public void blackListToken(String token) {
        Date tiempo = jwtService.getExpiration(token);

        // Generalizar la obtención del identificador
        String identificador = jwtService.getIdentificadorFromToken(token);

        // Crear el DTO con el token y el identificador
        BlackListTokenDTO blackListTokenDto = BlackListTokenDTO.builder()
                .token(token)
                .fechaExpiracion(Utilidades.convertToLocalDateTime(tiempo))
                .codigoPersona(identificador) // Puede ser código estudiante, asistencia, etc.
                .build();

        // Guardar el token en la lista negra
        blackListTokenRepository.save(blackListTokenMapper.dtoToEntity(blackListTokenDto));
    }

    @Override
    public boolean isTokenBlackListed(String token) {
        return blackListTokenRepository.existsByToken(token);
    }
}
