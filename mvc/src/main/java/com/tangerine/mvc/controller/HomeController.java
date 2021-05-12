package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Cliente;
import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/")
    public String showHome() {
        return "/frontoffice/index";
    }

    @GetMapping("/proyectos")
    public String showProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();;
        model.addAttribute("listaproyectos", proyectos);
        return "/frontoffice/proyectos";
    }



}
