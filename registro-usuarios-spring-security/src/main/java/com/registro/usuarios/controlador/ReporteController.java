package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Arriendo;
import com.registro.usuarios.repositorio.ArriendoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/reportes"})
public class ReporteController {

    @Autowired
    ArriendoRepositorio arriendoRepositorio;

    //todo: Agregar método para generar una tabla con todos los arriendos

    //Método para generar una tabla con todos los arriendos
    @GetMapping
    public String listarArriendos(Model model) {
        List<Arriendo> arriendos = arriendoRepositorio.findAll();
        model.addAttribute("arriendos", arriendos);
        return "reportes";
    }
}
