package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.BicicletaRegistroDTO;
import com.registro.usuarios.modelo.Bicicleta;

import java.util.List;

/**
 * Created by ignac on 23-06-2023.
 */
public interface BicicletaServicio {
    public Bicicleta guardarBicicleta(BicicletaRegistroDTO registroDTO);

    public List<Bicicleta> listarBicicletas();

    public Bicicleta buscarBicicleta(Long idBicicleta);

    public boolean eliminarBicicleta(Long idBicicleta);

    public Bicicleta actualizarBicicleta(Bicicleta bicicleta);
}
