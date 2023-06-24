package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.ReparacionDTO;
import com.registro.usuarios.modelo.Reparacion;

/**
 * Created by ignac on 23-06-2023.
 */
public interface ReparacionServicio {
    Reparacion repararBicicleta(ReparacionDTO reparacionDTO);
}
