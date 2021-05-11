package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProyectoService {

    public List<Proyecto> getProyectos(){
        RestTemplate restTemplate = new RestTemplate();
        Proyecto[] proyectosArray = restTemplate.getForObject("http://localhost:5000/api/proyecto", Proyecto[].class);
        return Arrays.asList(proyectosArray);
    }

    public Proyecto addProyecto(Proyecto proyectoToAdd) {
        RestTemplate restTemplate = new RestTemplate();
        Proyecto proyecto = restTemplate.postForObject("http://localhost:5000/api/proyecto", proyectoToAdd, Proyecto.class);
        return proyecto;
    }
}
