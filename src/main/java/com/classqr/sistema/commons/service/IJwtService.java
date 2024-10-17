package com.classqr.sistema.commons.service;
import com.classqr.sistema.commons.dto.EstudianteDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    String getToken(UserDetails userDetails);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
