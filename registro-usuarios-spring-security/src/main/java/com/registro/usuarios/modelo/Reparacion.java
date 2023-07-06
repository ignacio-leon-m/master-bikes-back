package com.registro.usuarios.modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reparacion")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rep")
    private Long idReparacion;
    @Column(name = "fecha_ingreso", nullable = false)
    private String fechaIng;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "fecha_entrega", nullable = false)
    private String fechaEntrega;
    @ManyToOne // Muchas reparaciones pueden ser realizadas por un usuario
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
