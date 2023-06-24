package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.BicicletaRegistroDTO;
import com.registro.usuarios.modelo.Bicicleta;
import com.registro.usuarios.repositorio.BicicletaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ignac on 23-06-2023.
 */

@Service
public class BicicletaServicioImpl implements BicicletaServicio {

    private BicicletaRepositorio bicicletaRepositorio;

    public BicicletaServicioImpl(BicicletaRepositorio bicicletaRepositorio) {
        super();
        this.bicicletaRepositorio = bicicletaRepositorio;
    }

    @Override
    public Bicicleta guardarBicicleta(BicicletaRegistroDTO registroDTO) {
        Bicicleta bicicleta = new Bicicleta(
                registroDTO.getMarca(),
                registroDTO.getModelo(),
                registroDTO.getAro(),
                registroDTO.getTipo(),
                registroDTO.getColor(),
                registroDTO.getEstado(),
                registroDTO.getPrecioArr()
        );

        return bicicletaRepositorio.save(bicicleta);
    }

    @Override
    public List<Bicicleta> listarBicicletas() {
        return bicicletaRepositorio.findAll();
    }


    @Override
    public Bicicleta buscarBicicleta(Long idBicicleta) {
        return bicicletaRepositorio.findById(idBicicleta)
                .orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    @Override
    public boolean eliminarBicicleta(Long idBicicleta) {
        return false;
    }

    @Override
    public Bicicleta actualizarBicicleta(Bicicleta bicicleta) {
        return null;
    }
}
