package com.classqr.sistema.commons.service.impl;

import com.classqr.sistema.commons.dto.*;
import com.classqr.sistema.commons.service.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class JwtService implements IJwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    // Este método ahora acepta cualquier objeto que implemente UserDetails
    @Override
    public String getToken(UserDetails userDetails) {
        Map<String, Object> additionalClaims = new HashMap<>();
        long expirationTimeInMillis = 24 * 60 * 60 * 1000; // Valor por defecto: 24 horas

        // Asume que el UserDetails es del tipo EstudianteSeguridadDTO, QrSeguridadDTO, o ProfesorSeguridadDTO
        if (userDetails instanceof EstudianteSeguridadDTO estudianteSeguridadDTO) {
            additionalClaims.put("codigoEstudiante", estudianteSeguridadDTO.getCodigoEstudiante());
            additionalClaims.put("nombreCompleto", estudianteSeguridadDTO.getNombresEstudiante() + ' ' + estudianteSeguridadDTO.getApellidosEstudiante());
        } else if (userDetails instanceof QrSeguridadDTO qrSeguridadDTO) {
            additionalClaims.put("codigoQr", qrSeguridadDTO.getCodigoQr());
            expirationTimeInMillis = 30 * 60 * 1000; // Si es QR, el token dura 30 minutos
        } else if (userDetails instanceof ProfesorSeguridadDTO profesorSeguridadDTO) {
            additionalClaims.put("codigoProfesor", profesorSeguridadDTO.getCodigoProfesor());
            additionalClaims.put("nombreCompleto", profesorSeguridadDTO.getNombresProfesor());
        }

        return buildToken(additionalClaims, userDetails, expirationTimeInMillis);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return getClaims(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public AuthResponseDTO generarToken(UserDetails userDetails) {
        return AuthResponseDTO.builder().token(getToken(userDetails)).build();
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token) {
        return getClaims(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    public String getIdentificadorFromToken(String token) {
        Claims claims = getAllClaims(token);

        if (claims.containsKey("codigoEstudiante")) {
            return claims.get("codigoEstudiante", String.class);
        } else if (claims.containsKey("codigoAsistencia")) {
            return claims.get("codigoAsistencia", String.class);
        } else if (claims.containsKey("codigoProfesor")) {
            return claims.get("codigoProfesor", String.class);
        }
        throw new IllegalArgumentException("Token no contiene un identificador válido.");
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails user, long expirationTimeInMillis) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
                .signWith(key)
                .compact();
    }
}
