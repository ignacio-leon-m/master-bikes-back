package com.registro.usuarios.modelo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ignac on 21-06-2023.
 */
@Data
@Entity
@Table(name = "bicicleta")
public class Bicicleta {
    @Id
    @Column(name = "id_bicicleta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBicicleta;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "modelo", nullable = false)
    private String modelo;
    @Column(name = "aro", nullable = false)
    private int aro;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "precio_arr", nullable = false)
    private BigDecimal precioArr;
    @OneToMany
    @JoinColumn(name = "bicicleta_id")
    private List<Arriendo> arriendos;
}
