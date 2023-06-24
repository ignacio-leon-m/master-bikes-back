package com.registro.usuarios.dto;

/**
 * Created by ignac on 24-06-2023.
 */
public class ReparacionDTO {
    private Long idReparacion;
    private String fechaIng;
    private String descripcion;
    private String estado;
    private String fechaEntrega;
    private Long usuarioId;

    public ReparacionDTO() {
    }

    public ReparacionDTO(String fechaIng, String descripcion, String estado, String fechaEntrega, Long usuarioId) {
        this.fechaIng = fechaIng;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.usuarioId = usuarioId;
    }

    public Long getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Long idReparacion) {
        this.idReparacion = idReparacion;
    }

    public String getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(String fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
