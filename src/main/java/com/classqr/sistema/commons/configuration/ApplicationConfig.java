package com.classqr.sistema.commons.configuration;

import com.classqr.sistema.commons.dto.EstudianteSeguridadDTO;
import com.classqr.sistema.commons.dto.ProfesorSeguridadDTO;
import com.classqr.sistema.commons.entity.EstudianteEntity;
import com.classqr.sistema.commons.entity.ProfesorEntity;
import com.classqr.sistema.commons.repository.EstudianteRepository;
import com.classqr.sistema.commons.repository.ProfesorRepository;
import com.classqr.sistema.commons.util.mapper.EstudianteMapper;
import com.classqr.sistema.commons.util.mapper.ProfesorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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

    private final ProfesorMapper profesorMapper;

    private final ProfesorRepository profesorRepository;

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
            // Primero intenta encontrar un estudiante
            EstudianteEntity estudiante = estudianteRepository.findByCodigoEstudiante(username).orElse(null);
            if (estudiante != null) {
                return new EstudianteSeguridadDTO(estudianteMapper.entityToDto(estudiante));
            }

            ProfesorEntity profesor = profesorRepository.findByNumeroDocumento(username).orElseThrow(
                    () -> new UsernameNotFoundException("Profesor no encontrado"));
            return new ProfesorSeguridadDTO(profesorMapper.entityToDto(profesor));
        };
    }


    @Bean
    @Profile("dev")
    public WebMvcConfigurer corsConfigurerDev() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Aplica a todas las rutas
                        .allowedOrigins("http://localhost:4200")  // Permitir solo el origen de desarrollo
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");  // Permitir todos los headers en desarrollo
            }
        };
    }

    @Bean
    @Profile("prod")
    public WebMvcConfigurer corsConfigurerProd() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Limitar a rutas específicas en producción
                        .allowedOrigins("https://mi-sitio.com")  // Solo permite el origen de producción
                        .allowedMethods("GET", "POST")  // Solo permite los métodos necesarios
                        .allowedHeaders("Authorization", "Content-Type");  // Limitar las cabeceras permitidas
            }
        };
    }

}
