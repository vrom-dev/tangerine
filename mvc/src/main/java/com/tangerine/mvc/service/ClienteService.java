package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Clienteservice usa un objeto proxy para acceder al Servicio Web. En el momento de la solicitud,
 */
@Service
public class ClienteService {

    /**
     * Method to get an array of clients in JSON format from the api and transform it into JAVA objects
     * The array is transformed into a List
     *
     * @return List of Cliente
     */
    public List<Cliente> getClientes() {
        RestTemplate restTemplate = new RestTemplate();
        Cliente[] clienteArray = restTemplate.getForObject("http://localhost:5000/api/cliente", Cliente[].class);
        return Arrays.asList(clienteArray);
    }
}
