package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.entity.EstudianteEntity;
import com.classqr.sistema.commons.util.constant.Constantes;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class EstudianteSeguridadDTO extends EstudianteDTO implements UserDetails {

    private String password;

    public EstudianteSeguridadDTO(EstudianteDTO estudianteDTO) {
        super(estudianteDTO.getCodigoEstudiante(),
                estudianteDTO.getNombresEstudiante(),
                estudianteDTO.getApellidosEstudiante(),
                estudianteDTO.getNumeroDocumento(),
                estudianteDTO.getIdTipoDocumentoEntityFk(),
                estudianteDTO.getAsistio());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Constantes.ROL_ESTUDIANTE));
    }

    @Override
    public String getPassword() {
        return super.getNumeroDocumento();
    }

    @Override
    public String getUsername() {
        return super.getCodigoEstudiante();
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
