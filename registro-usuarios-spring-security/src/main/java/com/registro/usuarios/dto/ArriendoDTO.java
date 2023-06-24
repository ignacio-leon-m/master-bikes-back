package com.registro.usuarios.dto;

import java.time.LocalDate;

/**
 * Created by ignac on 23-06-2023.
 */
public class ArriendoDTO {
    private String fechaIni;
    private String fechaTer;
    private String formaPago;
    private String detallesPago;
    private Boolean garantia;
    private int montoGarantia;
    private Long bicicletaId; // ID de la bicicleta seleccionada por el cliente
    private Long usuarioId; // ID del usuario que arrienda la bicicleta

    public ArriendoDTO() {
    }

    public ArriendoDTO(String fechaIni, String fechaTer, String formaPago, String detallesPago, Boolean garantia, int montoGarantia, Long bicicletaId, Long usuarioId) {
        this.fechaIni = fechaIni;
        this.fechaTer = fechaTer;
        this.formaPago = formaPago;
        this.detallesPago = detallesPago;
        this.garantia = garantia;
        this.montoGarantia = montoGarantia;
        this.bicicletaId = bicicletaId;
        this.usuarioId = usuarioId;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaTer() {
        return fechaTer;
    }

    public void setFechaTer(String fechaTer) {
        this.fechaTer = fechaTer;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getDetallesPago() {
        return detallesPago;
    }

    public void setDetallesPago(String detallesPago) {
        this.detallesPago = detallesPago;
    }

    public Boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(Boolean garantia) {
        this.garantia = garantia;
    }

    public int getMontoGarantia() {
        return montoGarantia;
    }

    public void setMontoGarantia(int montoGarantia) {
        this.montoGarantia = montoGarantia;
    }

    public Long getBicicletaId() {
        return bicicletaId;
    }

    public void setBicicletaId(Long bicicletaId) {
        this.bicicletaId = bicicletaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
