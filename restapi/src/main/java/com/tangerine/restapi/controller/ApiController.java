package com.tangerine.restapi.controller;

import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ApiController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/proyecto")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    @PostMapping("/proyecto/{id}")
    public List<Proyecto> getAllProyectos(@PathVariable Integer id) {
    }

}
