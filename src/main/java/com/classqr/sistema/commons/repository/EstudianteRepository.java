package com.classqr.sistema.commons.repository;

import com.classqr.sistema.commons.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Integer> {

    Optional<EstudianteEntity> findByNumeroDocumento(String numeroDocumento);
}
