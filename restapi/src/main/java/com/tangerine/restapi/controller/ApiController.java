package com.tangerine.restapi.controller;

import com.tangerine.restapi.exceptions.ProjectNotFoundException;
import com.tangerine.restapi.model.Cliente;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.service.ClienteService;
import com.tangerine.restapi.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ApiController {
    @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/proyecto")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    @GetMapping("/proyecto/{id}")
    public Proyecto getProyecto(@PathVariable Integer id) {
        return proyectoService
                .findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    /**
     *  ResponseeEntity wrapper
     */
    @PostMapping("/proyecto")
    public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto) {
        Proyecto p = proyectoService.saveProyecto(proyecto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() {
        return clienteService.findAll();
    }
}
