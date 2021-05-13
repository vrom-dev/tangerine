package com.tangerine.restapi.controller;

import com.tangerine.restapi.exceptions.ProjectNotFoundException;
import com.tangerine.restapi.model.Cargo;
import com.tangerine.restapi.model.Cliente;
import com.tangerine.restapi.model.Persona;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.service.CargoService;
import com.tangerine.restapi.service.ClienteService;
import com.tangerine.restapi.service.PersonaService;
import com.tangerine.restapi.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador que mapea las peticiones que llegan a /api
 * Segun la url mapeada devolvera la informacion correspondiente desde la BBDD
 * Tiene injectadas dependencias de ProyectoService y ClienteService
 */
@RestController
@RequestMapping(path = "/api")
public class ApiController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    CargoService cargoService;

    @Autowired
    PersonaService personaService;

    /**
     * Mapeando un GET en la ruta /api/proyecto devuelve una
     * lista de todos los proyectos de la BBDD
     *
     * @return Lista de proyectos
     */
    @GetMapping("/proyecto")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    /**
     * Mapeando un GET en la ruta /api/idProyecto devuelve el
     * proyecto con ID espeficicada en la URL desde la BBDD
     *
     * @param id
     * @return Proyecto con id especificado
     */
    @GetMapping("/proyecto/{id}")
    public Proyecto getProyecto(@PathVariable Integer id) {
        return proyectoService
                .findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    /**
     * Mapea un POST desde el formulario que hay en la ruta /proyecto
     * Ese formulario que cuando es enviado debe contener la informacion
     * de un nuevo proyecto es guardado en la BBDD
     *
     * @param proyecto
     * @return Devuelve el mismo proyecto que es introducido
     */
    @PostMapping("/proyecto")
    public ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto) {
        Proyecto p = proyectoService.saveProyecto(proyecto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    /* EDITAR */
    @PutMapping("/proyecto/edit")
    public Proyecto editProyecto(@RequestBody Proyecto proyecto) {

        System.out.println(proyecto);

        return proyectoService.editProyecto(proyecto);
    }

    @DeleteMapping("/proyecto/{id}")
    public void deleteProyecto(@PathVariable Integer id) {
        proyectoService.deleteProyecto(id);
    }

    /**
     * Mapea un GET desde la ruta /cliente y devuelve todos los clientes
     * que hay en la BBDD para poder mostrarlos en el formulario de
     * creacion de un nuevo proyecto
     *
     * @return Lista de clientes
     */
    @GetMapping("/cliente")
    public List<Cliente> getAllCliente() {
        return clienteService.findAll();
    }


    /* Metodos de Cargo y Persona */
    @GetMapping("/socio")
    public List<Persona> getAllPersonas() {

        return personaService.findAll();
    }

    @GetMapping("socio/{id}")
    public Persona getPersona(@PathVariable Integer id) {

        return personaService.findById(id).orElseThrow(/*Todo*/);
    }

    @PostMapping("/socio")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {

        Persona p = personaService.savePersona(persona);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping("/cargo")
    public List<Cargo> getAllCargos() {
        return cargoService.findAll();
    }

}
