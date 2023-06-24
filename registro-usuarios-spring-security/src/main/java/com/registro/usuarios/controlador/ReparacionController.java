package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.ReparacionDTO;
import com.registro.usuarios.servicio.ReparacionServicio;
import com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by ignac on 24-06-2023.
 */
@Controller
@RequestMapping("/reparacion")
public class ReparacionController {
    private final UsuarioServicio usuarioServicio;
    private final ReparacionServicio reparacionServicio;

    public ReparacionController(ReparacionServicio reparacionServicio, UsuarioServicio usuarioServicio) {
        super();
        this.reparacionServicio = reparacionServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("reparacion")
    public ReparacionDTO retornarNuevaReparacionDTO() {
        return new ReparacionDTO();
    }

    @GetMapping
    public String MostrarFormularioReparacion(Model model, Principal principal) {
        //Obtener id del usuario logueado
        String nombreUsuario = obtenerNombreUsuarioLogueado(principal);
        Long usuarioId = usuarioServicio.buscarIdPorUsername(nombreUsuario);

        // Crear una nueva instancia de ReparacionDTO y establecer el usuarioId
        ReparacionDTO reparacionDTO = new ReparacionDTO();
        reparacionDTO.setUsuarioId(usuarioId);

        model.addAttribute("reparacion", reparacionDTO);

        return "reparacion";
    }

    private String obtenerNombreUsuarioLogueado(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @PostMapping
    public String registrarReparacion(@ModelAttribute("reparacion") ReparacionDTO reparacionDTO) {
        reparacionServicio.repararBicicleta(reparacionDTO);

        return "redirect:/reparacion";
    }
}
