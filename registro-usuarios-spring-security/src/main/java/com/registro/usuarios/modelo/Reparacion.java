package com.registro.usuarios.modelo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reparacion")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rep")
    private Long idReparacion;
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIng;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "bicicleta_id", nullable = false)
    private Bicicleta bicicleta;

}
