package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.BicicletaRegistroDTO;
import com.registro.usuarios.servicio.BicicletaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bicicleta")
public class BicicletaController {

    private BicicletaServicio bicicletaServicio;

    public BicicletaController(BicicletaServicio bicicletaServicio) {
        super();
        this.bicicletaServicio = bicicletaServicio;
    }

    @ModelAttribute("bicicleta")
    public BicicletaRegistroDTO retornarNuevaBicicletaRegistroDTO() {
        return new BicicletaRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioBicicleta() {
        return "bicicleta";
    }

    @PostMapping
    public String registrarBicicleta(@ModelAttribute("bicicleta") BicicletaRegistroDTO registroDTO) {
        bicicletaServicio.guardarBicicleta(registroDTO);
        return "redirect:/bicicleta?exito";
    }

}