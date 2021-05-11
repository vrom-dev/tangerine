package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProyectosService {

    public List<Proyecto> getProyectos(){
        RestTemplate restTemplate = new RestTemplate();

        Proyecto[] proyectosArray = restTemplate.getForObject("https://localhost:5000/api/proyecto", Proyecto[].class);
        return Arrays.asList(proyectosArray);
    }
}
