package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Mensaje;
import com.tangerine.restapi.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    MensajeRepository mensajeRepository;

    public List<Mensaje> findAll() {


        return mensajeRepository.findAll();
    }

    public Optional<Mensaje> findById(Integer id) {

        return mensajeRepository.findById(id);
    }

    public Mensaje saveMensaje(Mensaje mensaje) {

        return mensajeRepository.save(mensaje);
    }
}
