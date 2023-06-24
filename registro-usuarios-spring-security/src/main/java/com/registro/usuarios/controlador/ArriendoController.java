package com.registro.usuarios.controlador;

import com.registro.usuarios.dto.ArriendoDTO;
import com.registro.usuarios.modelo.Bicicleta;
import com.registro.usuarios.servicio.ArriendoServicio;
import com.registro.usuarios.servicio.BicicletaServicio;
import com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by ignac on 22-06-2023.
 */
@Controller
@RequestMapping("/arriendo")
public class ArriendoController {
    private final ArriendoServicio arriendoServicio;
    private final BicicletaServicio bicicletaServicio;
    private final UsuarioServicio usuarioServicio;


    public ArriendoController(ArriendoServicio arriendoServicio, BicicletaServicio bicicletaServicio, UsuarioServicio usuarioServicio) {
        super();
        this.arriendoServicio = arriendoServicio;
        this.bicicletaServicio = bicicletaServicio;
        this.usuarioServicio = usuarioServicio;
    }

    //Éste método retorna un nuevo objeto ArriendoDTO
    @ModelAttribute("arriendo")
    public ArriendoDTO retornarNuevoArriendoDTO() {
        return new ArriendoDTO();
    }


    //Éste método muestra el formulario de arriendo
    @GetMapping
    public String mostrarFormularioArriendo(Model model, Principal principal) {
        List<Bicicleta> bicicletasDisponibles = bicicletaServicio.listarBicicletas();
        model.addAttribute("bicicletas", bicicletasDisponibles);
        //Obtener id del usuario logueado
        String nombreUsuario = obtenerNombreUsuarioLogueado(principal);
        Long usuarioId = usuarioServicio.buscarIdPorUsername(nombreUsuario);
        model.addAttribute("usuarioId", usuarioId);

        return "arriendo";
    }

    private String obtenerNombreUsuarioLogueado(Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = auth.getName();
        return nombreUsuario;
    }

    //Éste método recibe los datos del formulario de arriendo
    @PostMapping
    public String registrarArriendo(@ModelAttribute("arriendo") ArriendoDTO registroDTO, BindingResult result) {
        if (result.hasErrors()) {
            // Manejar los errores de validación
            return "formulario-arrendamiento";
        }

        LocalDate fechaInicio = registroDTO.getFechaIni();
        LocalDate fechaTermino = registroDTO.getFechaTer();

        if (fechaInicio.isAfter(fechaTermino)) {
            result.rejectValue("fechaIni", "error.fechaIni", "La fecha de inicio debe ser menor a la fecha de término");
            return "formulario-arrendamiento";
        }

        arriendoServicio.arrendarBicicleta(registroDTO);
        Bicicleta bicicleta = bicicletaServicio.buscarBicicleta(registroDTO.getBicicletaId());
        bicicleta.setEstado("Arrendada");
        bicicletaServicio.actualizarBicicleta(bicicleta);

        return "redirect:/arriendo?exito";
    }

    //Éste método muestra el formulario de arriendo
    @GetMapping("/seleccionar/{bicicletaId}")
    public String seleccionarBicicleta(@PathVariable Long bicicletaId, Model model) {
        Bicicleta bicicleta = bicicletaServicio.buscarBicicleta(bicicletaId);

        model.addAttribute("bicicleta", bicicleta);
        return "formulario-arrendamiento";
    }


}
