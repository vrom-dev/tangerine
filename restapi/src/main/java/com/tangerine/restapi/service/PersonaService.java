package com.tangerine.restapi.service;


import com.tangerine.restapi.model.Persona;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> findAll(){

        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Integer id){

        return personaRepository.findById(id);
    }

    public Persona savePersona(Persona persona) {

        return personaRepository.save(persona);

    }


}
