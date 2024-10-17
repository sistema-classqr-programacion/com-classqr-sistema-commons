package com.classqr.sistema.commons.configuration;

import com.classqr.sistema.commons.dto.EstudianteSeguridadDTO;
import com.classqr.sistema.commons.entity.EstudianteEntity;
import com.classqr.sistema.commons.repository.EstudianteRepository;
import com.classqr.sistema.commons.util.mapper.EstudianteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final EstudianteRepository estudianteRepository;

    private final EstudianteMapper estudianteMapper;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> {
            EstudianteEntity usuario = estudianteRepository.findByNumeroDocumento(username).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
            return new EstudianteSeguridadDTO(estudianteMapper.entityToDto(usuario));
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Aplica a todas las rutas
                        .allowedOrigins("http://localhost:4200")  // Solo permite este origen
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);  // Permite el uso de credenciales si es necesario
            }
        };
    }

}
