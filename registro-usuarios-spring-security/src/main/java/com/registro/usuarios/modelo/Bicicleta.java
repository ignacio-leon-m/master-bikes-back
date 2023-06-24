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

    public Bicicleta(String marca, String modelo, int aro, String tipo, String color, String estado, String precioArr) {
        this.marca = marca;
        this.modelo = modelo;
        this.aro = aro;
        this.tipo = tipo;
        this.color = color;
        this.estado = estado;
        this.precioArr = new BigDecimal(precioArr);
    }

    public Bicicleta() {

    }

    public Long getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(Long idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecioArr() {
        return precioArr;
    }

    public void setPrecioArr(BigDecimal precioArr) {
        this.precioArr = precioArr;
    }

    public List<Arriendo> getArriendos() {
        return arriendos;
    }

    public void setArriendos(List<Arriendo> arriendos) {
        this.arriendos = arriendos;
    }
}
