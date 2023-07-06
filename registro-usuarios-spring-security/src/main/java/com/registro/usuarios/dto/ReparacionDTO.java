package com.registro.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionDTO {
    private Long idReparacion;
    private String fechaIng;
    private String descripcion;
    private String estado;
    private String fechaEntrega;
    private Long usuarioId;

    public ReparacionDTO(String fechaIng, String descripcion, String estado, String fechaEntrega, Long usuarioId) {
        this.fechaIng = fechaIng;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.usuarioId = usuarioId;
    }
}
