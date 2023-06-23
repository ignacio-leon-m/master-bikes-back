package com.registro.usuarios.servicio;

import com.registro.usuarios.dto.ArriendoDTO;
import com.registro.usuarios.modelo.Arriendo;
import com.registro.usuarios.modelo.Bicicleta;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.ArriendoRepositorio;
import com.registro.usuarios.repositorio.BicicletaRepositorio;
import com.registro.usuarios.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ArriendoServicioImpl implements ArriendoServicio {
    //Inyeccion de dependencias
    private final ArriendoRepositorio arriendoRepositorio;

    private final BicicletaRepositorio bicicletaRepositorio;

    private final UsuarioRepositorio usuarioRepositorio;

    //Constructor
    ArriendoServicioImpl(ArriendoRepositorio arriendoRepositorio, BicicletaRepositorio bicicletaRepositorio, UsuarioRepositorio usuarioRepositorio) {
        super();
        this.arriendoRepositorio = arriendoRepositorio;
        this.bicicletaRepositorio = bicicletaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //Metodos de la interfaz

    //Metodo para guardar un arriendo
    @Override
    public Arriendo arrendarBicicleta(ArriendoDTO arriendoDTO) {
        Bicicleta bicicleta = bicicletaRepositorio.findById((arriendoDTO.getBicicletaId()))
                .orElseThrow(() -> new RuntimeException("No se encontro la bicicleta"));
        Usuario usuario = usuarioRepositorio.findById((arriendoDTO.getUsuarioId()))
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario"));

        Arriendo arriendo = new Arriendo();
        arriendo.setBicicleta(bicicleta);
        arriendo.setUsuario(usuario);
        arriendo.setFechaIni(arriendoDTO.getFechaIni());
        arriendo.setFechaTer(arriendoDTO.getFechaTer());
        arriendo.setFormaPago(arriendoDTO.getFormaPago());
        arriendo.setDetallesPago(arriendoDTO.getDetallesPago());
        arriendo.setGarantia(arriendoDTO.getGarantia());
        arriendo.setMontoGarantia(arriendoDTO.getMontoGarantia());
        return arriendoRepositorio.save(arriendo);  //Guarda el arriendo en la base de datos
    }

    @Override
    public boolean verificarDisponibilidad(ArriendoDTO arriendoDTO) {
        return false;
    }

    @Override
    public void procesarPago(Arriendo arriendo, String formaPago, String detallePago) {

    }

    @Override
    public void solicitarGarantia(Arriendo arriendo) {

    }
}
