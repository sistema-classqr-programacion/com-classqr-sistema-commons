package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.util.constant.Constantes;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ProfesorSeguridadDTO extends ProfesorDTO implements UserDetails {

    public ProfesorSeguridadDTO(ProfesorDTO profesorDTO) {
        super(profesorDTO.getCodigoProfesor(),
                profesorDTO.getNombresProfesor(),
                profesorDTO.getApellidosProfesor(),
                profesorDTO.getNumeroDocumento(),
                profesorDTO.getCorreoProfesor(),
                profesorDTO.getPasswordProfesor(),
                profesorDTO.getIdTipoDocumentoEntityFk());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Constantes.ROL_PROFESOR));
    }

    @Override
    public String getPassword() {
        return super.getPasswordProfesor();
    }

    @Override
    public String getUsername() {
        return super.getNumeroDocumento();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
