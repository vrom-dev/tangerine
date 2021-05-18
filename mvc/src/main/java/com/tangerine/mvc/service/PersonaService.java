package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Persona;
import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Luis Rojo
 * Clase de servicio PersonaService
 */
@Service
public class PersonaService {

    /**
     * Method to get an array of Persona from the api in JSON format. It is converted into JAVA Persona objects
     * Then the array is converted to a List
     *
     * @return
     */
    public List<Persona> getPersonas() {
        RestTemplate restTemplate = new RestTemplate();
        Persona[] personasArray = restTemplate.getForObject("http://localhost:5000/api/socio", Persona[].class);
        return Arrays.asList(personasArray);
    }

    public Persona getById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Persona persona = restTemplate.getForObject("http://localhost:5000/api/socio/{id}", Persona.class, id);

        return persona;
    }

    /**
     * Metodo que inserta una persona a la base de datos y devuelve a la persona insertada.
     *
     * @param personaToAdd
     * @return persona
     */
    public Persona addPersona(Persona personaToAdd) {
        RestTemplate restTemplate = new RestTemplate();
        Persona persona = restTemplate.postForObject("http://localhost:5000/api/socio", personaToAdd, Persona.class);
        return persona;
    }

    public Persona editSocio(Persona updatedPersona) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:5000/api/socio/edit", updatedPersona);

        return updatedPersona;
    }

    public void borrarSocio(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:5000/api/socio/" + id);

    }

}
