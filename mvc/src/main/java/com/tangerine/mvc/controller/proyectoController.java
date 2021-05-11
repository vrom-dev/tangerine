package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class proyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/home")
    public String getAllProyectos() {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        proyectos.forEach(proyecto -> System.out.println(proyecto));
        return "home";
    }

}
