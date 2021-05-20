package com.tangerine.restapi.controller;

import com.tangerine.restapi.exceptions.MensajeNotFoundException;
import com.tangerine.restapi.exceptions.PersonaNotFoundException;
import com.tangerine.restapi.exceptions.ProjectNotFoundException;
import com.tangerine.restapi.model.*;
import com.tangerine.restapi.service.*;
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

    @Autowired
    MensajeService mensajeService;

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

    /**
     * Method to send to ProyectoService information of a Proyecto to be modified
     *
     * @param proyecto
     * @return
     */
    @PutMapping("/proyecto/edit")
    public Proyecto editProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.editProyecto(proyecto);
    }

    /**
     * Methos to send to ProyectoService a Proyecto to be deleted
     *
     * @param id
     */
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


    /**
     * Metodo que hace una peticion a PersonaService para recuperar un listado de personas
     * de la base de datos
     *
     * @return List<Persona>
     */
    @GetMapping("/socio")
    public List<Persona> getAllPersonas() {

        return personaService.findAll();
    }

    /**
     * Metodo que hace una peticion a PersonaService para recuperar un registro de persona
     * de la base de datos a partir de su id
     *
     * @param id
     * @return Persona
     */
    @GetMapping("socio/{id}")
    public Persona getPersona(@PathVariable Integer id) {

        return personaService
                .findById(id)
                .orElseThrow(PersonaNotFoundException::new);
    }

    /**
     * Metodo que controla la peticion POST para insertar un registro persona
     * en la base de datos. Devuelve un estado 201 (creado)
     *
     * @param persona
     * @return ResponseEntity<Persona>
     */
    @PostMapping("/socio")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        Persona p = personaService.savePersona(persona);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    /**
     * Metodo que controla la peticion PUT para editar un registro persona
     * en la base de datos.
     * @param persona
     * @return
     */

    @PutMapping("/socio/edit")
    public Persona editSocio(@RequestBody Persona persona) {
        return personaService.editPersona(persona);
    }

    /**
     * Merodo que contrlo la peticion DELETE para borrar un registro persona
     * en la base de datos.
     * @param id
     */

    @DeleteMapping("/socio/{id}")
    public void deleteSocio(@PathVariable Integer id) {
        personaService.deleteSocio(id);
    }

    /**
     * Metodo que controla la peticion GET para recuperar un listado de cargos de
     * la base de datos
     *
     * @return List<Cargo>
     */
    @GetMapping("/cargo")
    public List<Cargo> getAllCargos() {
        return cargoService.findAll();
    }

    /**
     * Metodo que controla la peticion GET para recuperar un listado de mensajes
     * de la base de datos
     * @return List<Mensaje>
     */

    @GetMapping("/mensajes")
    public List<Mensaje> getAllMensajes() {

        return mensajeService.findAll();
    }

    /**
     * Metodo que hace una peticion a mensajeService para recuperar un registro de mensaje
     * de la base de datos a partir de su id
     * @param id
     * @return Mensaje
     */

    @GetMapping("/mensajes/{id}")
    public Mensaje getMensajeById(@PathVariable Integer id) {

        return mensajeService
                .findById(id)
                .orElseThrow(MensajeNotFoundException::new);
    }

    /**
     * Metodo que controla la peticion POST para insertar un registro mensaje
     * en la base de datos. Devuelve un estado 201 (creado)
     * @param mensaje
     * @return ResponseEntity<Mensaje>
     */

    @PostMapping("/mensaje")
    public ResponseEntity<Mensaje> saveMensaje(@RequestBody Mensaje mensaje) {

        Mensaje m = mensajeService.saveMensaje(mensaje);
        return  new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    /**
     * Metodo que controla la peticion PUT para editar un registro mensaje
     * en la base de datos.
     * @param mensaje
     * @return
     */

    @PutMapping("/mensajes/edit")
    public Mensaje editMensaje(@RequestBody Mensaje mensaje) {
        return mensajeService.editMensaje(mensaje);
    }

    /**
     * Merodo que controlo la peticion DELETE para borrar un registro persona
     * en la base de datos.
     * @param id
     */

    @DeleteMapping("/mensajes/{id}")
    public void deleteMensaje(@PathVariable Integer id) {
        mensajeService.deleteMensaje(id);
    }

}
