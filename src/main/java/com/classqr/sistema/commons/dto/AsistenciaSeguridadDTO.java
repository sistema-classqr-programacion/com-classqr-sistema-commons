package com.classqr.sistema.commons.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * DTO de seguridad para la asistencia de un estudiante.
 * Esta clase extiende {@link AsistenciaDTO} e implementa {@link UserDetails} para integrarse con Spring Security.
 * Se utiliza para proporcionar los detalles de seguridad relacionados con la asistencia del estudiante,
 * como el rol, la cuenta y el estado de las credenciales.
 */
@Data
public class AsistenciaSeguridadDTO extends AsistenciaDTO implements UserDetails {

    /**
     * Constructor que inicializa el DTO de seguridad con los detalles de asistencia proporcionados en un {@link AsistenciaDTO}.
     * Valida que el código de asistencia no sea nulo.
     *
     * @param asistenciaDTO El DTO base de asistencia, no puede tener un {@code codigoAsistencia} nulo.
     * @throws IllegalArgumentException si el código de asistencia es nulo.
     */
    public AsistenciaSeguridadDTO(AsistenciaDTO asistenciaDTO) {
        super(asistenciaDTO.getCodigoAsistencia(),
                asistenciaDTO.getCodigoEstudianteFk(),
                asistenciaDTO.getCodigoProfesorFk(),
                asistenciaDTO.getCodigoCursoFk(),
                asistenciaDTO.getIpEstudiante(),
                asistenciaDTO.getFechaAsistencia());
        if (asistenciaDTO.getCodigoAsistencia() == null) {
            throw new IllegalArgumentException("El código de asistencia no puede ser nulo.");
        }
    }

    /**
     * Retorna una colección de las autoridades otorgadas a la asistencia.
     * En este caso, el rol es generado dinámicamente basado en el código del curso asociado a la asistencia.
     *
     * @return Una lista de {@link SimpleGrantedAuthority} que contiene el rol asociado.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + super.getCodigoCursoFk()));
    }

    /**
     * No se utiliza una contraseña para autenticar la asistencia, por lo que este método devuelve {@code null}.
     *
     * @return {@code null}, ya que no hay una contraseña asociada a la asistencia.
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * El nombre de usuario para esta implementación es el código de asistencia.
     *
     * @return El código de asistencia como el nombre de usuario.
     */
    @Override
    public String getUsername() {
        return super.getCodigoAsistencia();
    }

    /**
     * Indica si la cuenta de la asistencia ha expirado.
     * En este caso, verifica si la fecha de asistencia no es nula.
     *
     * @return {@code true} si la fecha de asistencia no es nula, {@code false} de lo contrario.
     */
    @Override
    public boolean isAccountNonExpired() {
        return super.getFechaAsistencia() != null;
    }

    /**
     * Indica si la cuenta de la asistencia está bloqueada.
     * En esta implementación, se asume que la cuenta no está bloqueada.
     *
     * @return {@code true}, ya que las cuentas de asistencia no están bloqueadas.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales de la asistencia han expirado.
     * En esta implementación, las credenciales no expiran.
     *
     * @return {@code true}, ya que las credenciales no expiran.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta de la asistencia está habilitada.
     * En esta implementación, las cuentas de asistencia están habilitadas por defecto.
     *
     * @return {@code true}, ya que las cuentas de asistencia están habilitadas.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
