package com.tangerine.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proyectos")
public class proyectoController {

    @Autowired Integer TO_BE_CHANGED;

    private static final Logger log = LoggerFactory.getLogger(proyectoController.class);

    // Listar proyectos
    @GetMapping("")
    public String listProyectos(Model m) {

        m.addAllAttribute("proyectList", TO_BE_CHANGED.findAll());

        return "proyectos";
    }

    // Add proyecto
    @PostMapping("/addProyecto")
    public String addProyecto(Proyecto proyecto) {


        return "proyectos";
    }

    //editar proyecto
    @GetMapping("/edit")
    public String editUser() {



        return "";
    }

    //borra proyecto
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {


        TO_BE_CHANGED.deleteById(id);
        return "UserList";
    }

    //guardar proyecto
    @PostMapping("/save")
    public String saveUser() {


        return "";
    }


}
