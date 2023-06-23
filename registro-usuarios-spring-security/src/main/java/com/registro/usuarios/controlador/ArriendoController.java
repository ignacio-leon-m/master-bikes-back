package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.ArriendoDTO;
import com.registro.usuarios.servicio.ArriendoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by ignac on 22-06-2023.
 */
public class ArriendoController {
    private final ArriendoServicio arriendoServicio;

    public ArriendoController(ArriendoServicio arriendoServicio) {
        super();
        this.arriendoServicio = arriendoServicio;
    }

    @ModelAttribute("arriendo")
    public ArriendoDTO retornarNuevoArriendoDTO() {
        return new ArriendoDTO();
    }

    @GetMapping
    public String mostrarFormularioArriendo() {
        return "arriendo";
    }

    @PostMapping
    public String registrarArriendo(@ModelAttribute("arriendo") ArriendoDTO registroDTO) {
        arriendoServicio.arrendarBicicleta(registroDTO);
        return "redirect:/arriendo?exito";
    }


}
