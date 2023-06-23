package com.registro.usuarios.dto;

/**
 * Created by ignac on 23-06-2023.
 */
public class BicicletaRegistroDTO {
    private Long idBicicleta;
    private String marca;
    private String modelo;
    private int aro;
    private String tipo;
    private String color;
    private String estado;
    private String precioArr;

    public BicicletaRegistroDTO() {
    }

    public BicicletaRegistroDTO(String marca, String modelo, int aro, String tipo, String color, String estado, String precioArr) {
        this.marca = marca;
        this.modelo = modelo;
        this.aro = aro;
        this.tipo = tipo;
        this.color = color;
        this.estado = estado;
        this.precioArr = precioArr;
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

    public String getPrecioArr() {
        return precioArr;
    }

    public void setPrecioArr(String precioArr) {
        this.precioArr = precioArr;
    }
}
