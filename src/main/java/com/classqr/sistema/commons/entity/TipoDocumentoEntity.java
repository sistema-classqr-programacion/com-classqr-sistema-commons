package com.classqr.sistema.commons.entity;

import com.classqr.sistema.commons.util.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_documento", schema = "classqr")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_documento_id_gen")
    @SequenceGenerator(name = "tipo_documento_id_gen", sequenceName = "tipo_documento_id_tipo_documento_seq", allocationSize = 1)
    @Column(name = "id_tipo_documento", nullable = false)
    private Integer id;


    @Column(name = "nombre_tipo_documento", columnDefinition = "tipo_documento_enum not null")
    private TipoDocumentoEnum nombreTipoDocumento;

}