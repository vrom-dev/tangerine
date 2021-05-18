package com.tangerine.mvc.service;
/**
 * Author Alberto (Tangerine)
 */
import com.tangerine.mvc.model.Mensaje;
import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Clase de tipo Servicio llamada MensajeService
 */
@Service
public class MensajeService {
    /**
     * Metodo que hace una peticion a la api que recoge una lista de mensajes de la BBDD.
     * @return
     */
    public List<Mensaje> getMensajes() {
        RestTemplate restTemplate = new RestTemplate();
        Mensaje[] mensajesArray = restTemplate.getForObject("http://localhost:5000/api/mensajes", Mensaje[].class);

        return Arrays.asList(mensajesArray);
    }


    public Mensaje getMensajeById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        Mensaje mensaje = restTemplate.getForObject("http://localhost:5000/api/mensajes/" + id, Mensaje.class, id);

        return mensaje;
    }
        /**
         * Metodo que inserta un mensaje a la BBDD y devuelve el mensaje insertado.
         * @param mensajeToAdd
         * @return
         */
    public Mensaje addMensaje(Mensaje mensajeToAdd) {
        RestTemplate restTemplate = new RestTemplate();
        Mensaje mensaje = restTemplate.postForObject("http://localhost:5000/api/mensaje/", mensajeToAdd, Mensaje.class );

        return mensaje;
    }

    public Mensaje updateMensaje(Mensaje updatedMensaje) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:5000/api/mensajes/edit", updatedMensaje);
        return updatedMensaje;
    }

    public void borrarMensaje(Integer id) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:5000/api/mensajes/" + id);
    }
}
