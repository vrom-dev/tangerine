package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Mensaje;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MensajeService {

    public List<Mensaje> getMensajes() {

        RestTemplate restTemplate = new RestTemplate();
        Mensaje[] mensajesArray = restTemplate.getForObject("http://localhost:5000/api/mensajes", Mensaje[].class);

        return Arrays.asList(mensajesArray);
    }

    public Mensaje addMensaje(Mensaje mensajeToAdd) {

        RestTemplate restTemplate = new RestTemplate();
        Mensaje mensaje = restTemplate.postForObject("http://localhost:5000/api/mensaje/", mensajeToAdd, Mensaje.class );

        return mensaje;
    }
}
