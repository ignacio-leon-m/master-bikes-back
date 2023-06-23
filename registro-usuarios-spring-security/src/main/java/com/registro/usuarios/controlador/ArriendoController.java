package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.ArriendoDTO;
import com.registro.usuarios.dto.BicicletaRegistroDTO;
import com.registro.usuarios.modelo.Bicicleta;
import com.registro.usuarios.servicio.ArriendoServicio;
import com.registro.usuarios.servicio.BicicletaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ignac on 22-06-2023.
 */
@Controller
@RequestMapping("/arriendo")
public class ArriendoController {
    private final ArriendoServicio arriendoServicio;

    private final BicicletaServicio bicicletaServicio;

    public ArriendoController(ArriendoServicio arriendoServicio, BicicletaServicio bicicletaServicio) {
        super();
        this.arriendoServicio = arriendoServicio;
        this.bicicletaServicio = bicicletaServicio;
    }

    @ModelAttribute("arriendo")
    public ArriendoDTO retornarNuevoArriendoDTO() {
        return new ArriendoDTO();
    }

    @GetMapping
    public String mostrarFormularioArriendo(Model model) {
        List<Bicicleta> bicicletasDisponibles = bicicletaServicio.listarBicicletas();
        model.addAttribute("bicicletas", bicicletasDisponibles);
        return "arriendo";
    }

    @PostMapping
    public String registrarArriendo(@ModelAttribute("arriendo") ArriendoDTO registroDTO) {
        arriendoServicio.arrendarBicicleta(registroDTO);
        return "redirect:/arriendo?exito";
    }


}
