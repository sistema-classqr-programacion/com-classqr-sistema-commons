package com.classqr.sistema.commons.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estudiante", schema = "classqr")
public class EstudianteEntity {
    @Id
    @Column(name = "codigo_estudiante", nullable = false)
    private String codigoEstudiante;

    @Column(name = "nombres_estudiante", nullable = false, length = 100)
    private String nombresEstudiante;

    @Column(name = "apellidos_estudiante", nullable = false, length = 100)
    private String apellidosEstudiante;

    @Column(name = "numero_documento", nullable = false, length = 50)
    private String numeroDocumento;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_documento_fk", nullable = false)
    private TipoDocumentoEntity idTipoDocumentoEntityFk;

}