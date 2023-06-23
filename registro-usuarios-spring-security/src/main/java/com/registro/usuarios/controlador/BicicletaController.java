package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Bicicleta;
import com.registro.usuarios.repositorio.BicicletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by ignac on 22-06-2023.
 */
@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {
    //Inyeccion de dependencias
    @Autowired
    public BicicletaRepositorio bicicletaRepositorio;

    //Métodos http
    //Agregar bicicleta
    @PostMapping("/agregar")
    public ResponseEntity<String> agregarBicicleta(
            @RequestParam("marca") String marca,
            @RequestParam("modelo") String modelo,
            @RequestParam("aro") int aro,
            @RequestParam("tipo") String tipo,
            @RequestParam("color") String color,
            @RequestParam("estado") String estado,
            @RequestParam("precioArr") BigDecimal precioArr
    ) {
        Bicicleta nuevaBicicleta = new Bicicleta();
        nuevaBicicleta.setMarca(marca);
        nuevaBicicleta.setModelo(modelo);
        nuevaBicicleta.setAro(aro);
        nuevaBicicleta.setTipo(tipo);
        nuevaBicicleta.setColor(color);
        nuevaBicicleta.setEstado(estado);
        nuevaBicicleta.setPrecioArr(precioArr);

        Bicicleta bicicletaGuardada = bicicletaRepositorio.save(nuevaBicicleta);
        if (bicicletaGuardada != null) {
            return ResponseEntity.ok("Bicicleta agregada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar bicicleta");
        }

    }
}
