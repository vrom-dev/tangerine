package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.CargoService;
import com.tangerine.mvc.service.ClienteService;
import com.tangerine.mvc.service.PersonaService;
import com.tangerine.mvc.service.ProyectoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/personas")
public class SocioController {
    @Autowired
    PersonaService personaService;
    @Autowired
    CargoService cargoService;

    @Autowired
    ProyectoService proyectoService;
    @Autowired
    ClienteService clienteService;

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    @GetMapping("")
    public String getAllProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        model.addAttribute("listaproyectos", proyectos);
        return "/backoffice/socios";
    }
}
