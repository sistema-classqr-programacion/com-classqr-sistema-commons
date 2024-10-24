package com.classqr.sistema.commons.repository;

import com.classqr.sistema.commons.entity.AsistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, String> {

    Optional<AsistenciaEntity> findByCodigoAsistencia(String codigoAsistencia);

}
