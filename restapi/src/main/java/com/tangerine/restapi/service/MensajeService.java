package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Mensaje;
import com.tangerine.restapi.model.Proyecto;
import com.tangerine.restapi.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Rojo (Tangerine)
 * Clase que se encarga de recoger las peticiones del controlador y solicitar al Repositorio
 * de mensajes la accion pertinente
 */

@Service
public class MensajeService {

    @Autowired
    MensajeRepository mensajeRepository;

    /**
     * Metodo que recupera una lista con los mensajes en la base de datos
     *
     * @return List<Mensaje>
     */

    public List<Mensaje> findAll() {


        return mensajeRepository.findAll();
    }

    /**
     * Metodo que recupera un objeto Mensaje de la base de datos en funcion del ID
     *
     * @param id
     * @return Mensaje
     */

    public Optional<Mensaje> findById(Integer id) {

        return mensajeRepository.findById(id);
    }

    /**
     * Metodo que guarda un objeto Mensaje en la base de datos
     * @param mensaje
     * @return
     */

    public Mensaje saveMensaje(Mensaje mensaje) {

        return mensajeRepository.save(mensaje);
    }

    public Mensaje editMensaje(Mensaje newMensaje) {

        Integer id = newMensaje.getIdmensaje();
        if (mensajeRepository.findById(id).isPresent()) {
            Mensaje mensaje = new Mensaje();
            mensaje.setIdmensaje(newMensaje.getIdmensaje());
            mensaje.setRemitente(newMensaje.getRemitente());
            mensaje.setFecha(newMensaje.getFecha());
            mensaje.setSubject(newMensaje.getSubject());
            mensaje.setMensaje(newMensaje.getMensaje());
            mensaje.setRespuesta(newMensaje.getRespuesta());
            mensajeRepository.save(mensaje);
            return mensaje;
        }
        return newMensaje;


    }

    public void deleteMensaje(Integer id) {
        mensajeRepository.deleteById(id);
    }
}
