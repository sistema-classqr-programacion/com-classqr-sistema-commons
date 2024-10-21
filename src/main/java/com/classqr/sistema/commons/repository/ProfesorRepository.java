package com.classqr.sistema.commons.repository;

import com.classqr.sistema.commons.entity.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorEntity,  String> {

    Optional<ProfesorEntity> findByNumeroDocumento(String numeroDocumento);

}
