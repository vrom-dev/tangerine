package com.tangerine.mvc.service;
/**
 * @Alberto (Tangerine)
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
     *Metodo que hace una petecion a una apirest que devuelve una lista de proyectos
     */
    public List<Proyecto> getProyectos(){
        RestTemplate restTemplate = new RestTemplate();
        Proyecto[] proyectosArray = restTemplate.getForObject("http://localhost:5000/api/proyecto", Proyecto[].class);
        return Arrays.asList(proyectosArray);
    }

    /**
     * Metodo que inserta un poryecto a la base de datos y devuelve el proyecto insertado.
     * @param proyectoToAdd
     * @return proyecto
     */
    public Proyecto addProyecto(Proyecto proyectoToAdd) {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto proyecto = restTemplate.postForObject("http://localhost:5000/api/proyecto", proyectoToAdd, Proyecto.class);
        return proyecto;
    }

}
