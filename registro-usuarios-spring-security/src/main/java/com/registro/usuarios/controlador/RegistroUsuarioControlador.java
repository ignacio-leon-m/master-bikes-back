package com.registro.usuarios.controlador;

import com.registro.usuarios.servicio.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;
    private EmailService emailService;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio, EmailService emailService) {
        super();
        this.usuarioServicio = usuarioServicio;
        this.emailService = emailService;
    }

    // Métodos HTTP
    // Éste método sirve para mostrar el formulario de registro de usuarios
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    // Éste método sirve para mostrar el formulario de registro de usuarios
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);

        // Envío del correo de confirmación
        String emailBody = "Felicitaciones, te has registrado exitosamente!";
        emailService.sendConfirmationEmail(registroDTO.getEmail(), "Confirmación de cuenta", emailBody);


        return "redirect:/registro?exito";
    }
}
