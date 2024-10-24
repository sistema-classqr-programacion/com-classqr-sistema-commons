package com.classqr.sistema.commons.dto;

import com.classqr.sistema.commons.util.constant.Constantes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class QrSeguridadDTO extends QrDTO implements UserDetails {

    public QrSeguridadDTO(QrDTO qrDTO) {
        super(qrDTO.getCodigoQr(),
                qrDTO.getFechaCreacionQr(),
                qrDTO.getFechaFinQr());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Constantes.ROL_QR));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return super.getCodigoQr();
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
