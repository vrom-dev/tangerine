package com.tangerine.mvc.service;
/**
 * @Alberto (Tangerine)
 */

import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Creacion de una clase de servicio llamada ProyectoService
 */
@Service
public class ProyectoService {
    /**
     * Metodo que hace una petecion a una apirest que devuelve una lista de proyectos
     */
    public List<Proyecto> getProyectos() {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto[] proyectosArray = restTemplate.getForObject("http://localhost:5000/api/proyecto", Proyecto[].class);
        return Arrays.asList(proyectosArray);
    }

    public Proyecto getById(Integer id) {

        // Not sure ir works Todo
        RestTemplate restTemplate = new RestTemplate();
        Proyecto proyecto = restTemplate.getForObject("http://localhost:5000/api/proyecto/{id}", Proyecto.class, id);

        return proyecto;
    }

    /**
     * Metodo que inserta un poryecto a la base de datos y devuelve el proyecto insertado.
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
     * @param updatedProyecto
     * @return the Projecto object with the changes made
     */
    public Proyecto updateProyecto(Proyecto updatedProyecto) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:5000/api/proyecto/edit", updatedProyecto);

        return updatedProyecto;
    }


    public void borrarProyecto(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:5000/api/proyecto/"+ id);

    }


}
