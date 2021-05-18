package com.tangerine.mvc.service;
/**
 * @Author Alberto (Tangerine)
 */

import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Creacion de una clase de servicio llamada ProyectoService
 */
@Service
public class ProyectoService {
    /**
     * Metodo que hace una peticion a la API y recupera una lista con todos los proyectos de la BBDD
     */
    public List<Proyecto> getProyectos() {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto[] proyectosArray = restTemplate.getForObject("http://localhost:5000/api/proyecto", Proyecto[].class);
        return Arrays.asList(proyectosArray);
    }

    /**
     * Metodo que hace una peticion a la API y un proyecto de la BBDD en funcion del id
     *
     * @param id
     * @return proyecto
     */
    public Proyecto getById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto proyecto = restTemplate.getForObject("http://localhost:5000/api/proyecto/{id}", Proyecto.class, id);

        return proyecto;
    }

    /**
     * Metodo que inserta un proyecto a la base de datos y devuelve el proyecto insertado
     *
     * @param proyectoToAdd
     * @return proyecto
     */
    public Proyecto addProyecto(Proyecto proyectoToAdd) {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto proyecto = restTemplate.postForObject("http://localhost:5000/api/proyecto", proyectoToAdd, Proyecto.class);
        return proyecto;
    }

    /**
     * Methos which sends to the api a Proyecto to be modified
     *
     * @param updatedProyecto
     * @return the Projecto object with the changes made
     */
    public Proyecto updateProyecto(Proyecto updatedProyecto) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:5000/api/proyecto/edit", updatedProyecto);

        return updatedProyecto;
    }

    /**
     * Metodo que envia una peticion DELETE a la API para eliminar un proyecto segun su ID
     *
     * @param id
     * @return void
     */
    public void borrarProyecto(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:5000/api/proyecto/" + id);

    }


}
