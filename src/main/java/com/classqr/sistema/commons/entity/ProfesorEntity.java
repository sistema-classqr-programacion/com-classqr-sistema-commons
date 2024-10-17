package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profesor", schema = "classqr")
public class ProfesorEntity {
    @Id
    @Column(name = "codigo_profesor", nullable = false)
    private String codigoProfesor;

    @Column(name = "nombres_profesor", nullable = false, length = 100)
    private String nombresProfesor;

    @Column(name = "apellidos_profesor", nullable = false, length = 100)
    private String apellidosProfesor;

    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_documento_fk", nullable = false)
    private TipoDocumentoEntity idTipoDocumentoEntityFk;

}