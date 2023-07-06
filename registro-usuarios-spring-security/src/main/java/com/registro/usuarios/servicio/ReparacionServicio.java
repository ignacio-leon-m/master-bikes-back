package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.ReparacionDTO;
import com.registro.usuarios.modelo.Reparacion;

public interface ReparacionServicio {
    Reparacion repararBicicleta(ReparacionDTO reparacionDTO);
}
