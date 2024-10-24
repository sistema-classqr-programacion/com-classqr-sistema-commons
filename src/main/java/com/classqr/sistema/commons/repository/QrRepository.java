package com.classqr.sistema.commons.repository;

import com.classqr.sistema.commons.entity.QrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QrRepository extends JpaRepository<QrEntity, String> {

    Optional<QrEntity> findByCodigoQr(String codigoQr);

}
