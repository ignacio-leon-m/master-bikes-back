package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.ArriendoDTO;
import com.registro.usuarios.modelo.Arriendo;

/**
 * Created by ignac on 23-06-2023.
 */
public interface ArriendoServicio {
    Arriendo arrendarBicicleta(ArriendoDTO arriendoDTO);

    boolean verificarDisponibilidad(ArriendoDTO arriendoDTO);

    void procesarPago(Arriendo arriendo, String formaPago, String detallePago);

    void solicitarGarantia(Arriendo arriendo);

}
