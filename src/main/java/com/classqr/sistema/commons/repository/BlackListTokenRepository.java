package com.classqr.sistema.commons.repository;

import com.classqr.sistema.commons.entity.BlackListTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListTokenRepository extends JpaRepository<BlackListTokenEntity, Integer> {

    Boolean existsByToken(String token);

}
