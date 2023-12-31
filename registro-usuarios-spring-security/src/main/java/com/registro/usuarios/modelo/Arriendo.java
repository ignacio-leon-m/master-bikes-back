package com.registro.usuarios.modelo;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ignac on 21-06-2023.
 */
@Data
@Entity
@Table(name = "arriendo")
public class Arriendo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_arriendo")
    private Long idArriendo;
    @Column(name = "fecha_ini", nullable = false)
    private String fechaIni;
    @Column(name = "fecha_ter", nullable = false)
    private String fechaTer;
    @Column(name = "forma_pago", nullable = false)
    private String formaPago;
    @Column(name = "detalles_pago")
    private String detallesPago;
    @Column(name = "garantia", nullable = false)
    private Boolean garantia;
    @Column(name = "monto_gar", nullable = false)
    private int montoGarantia;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "bicicleta_id", nullable = false)
    private Bicicleta bicicleta;


    public Arriendo() {
    }

    public Arriendo(String fechaIni, String fechaTer, String formaPago, String detallesPago, Boolean garantia, int montoGarantia, Usuario usuario, Bicicleta bicicleta) {
        this.fechaIni = fechaIni;
        this.fechaTer = fechaTer;
        this.formaPago = formaPago;
        this.detallesPago = detallesPago;
        this.garantia = garantia;
        this.montoGarantia = montoGarantia;
        this.usuario = usuario;
        this.bicicleta = bicicleta;
    }
}

