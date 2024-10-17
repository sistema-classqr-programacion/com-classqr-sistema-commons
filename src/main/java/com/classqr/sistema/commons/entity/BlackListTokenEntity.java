package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "black_list_token", schema = "classqr")
public class BlackListTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "black_list_token_id_gen")
    @SequenceGenerator(name = "black_list_token_id_gen", sequenceName = "black_list_token_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "token", nullable = false, length = 512)
    private String token;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDateTime fechaExpiracion;

    @Column(name = "codigo_persona", nullable = false, length = 5)
    private String codigoPersona;

}