package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.ReparacionDTO;
import com.registro.usuarios.modelo.Reparacion;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.BicicletaRepositorio;
import com.registro.usuarios.repositorio.ReparacionRepositorio;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

/**
 * Created by ignac on 23-06-2023.
 */
@Service
public class ReparacionServicioImpl implements ReparacionServicio {

    private final ReparacionRepositorio reparacionRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    ReparacionServicioImpl(ReparacionRepositorio reparacionRepositorio, UsuarioRepositorio usuarioRepositorio) {
        super();
        this.reparacionRepositorio = reparacionRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //Métodos de la interfaz

    @Override
    public Reparacion repararBicicleta(ReparacionDTO reparacionDTO) {
        Usuario usuario = usuarioRepositorio.findById(reparacionDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario"));

        Reparacion reparacion = new Reparacion();
        reparacion.setUsuario(usuario);
        reparacion.setDescripcion(reparacionDTO.getDescripcion());
        reparacion.setEstado(reparacionDTO.getEstado());
        reparacion.setFechaIng(reparacionDTO.getFechaIng());
        reparacion.setFechaEntrega(reparacionDTO.getFechaEntrega());

        return reparacionRepositorio.save(reparacion);
    }
}
