package com.tangerine.mvc.service;

import com.tangerine.mvc.model.Cliente;
import com.tangerine.mvc.model.Proyecto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    public List<Cliente> getClientes(){
        RestTemplate restTemplate = new RestTemplate();
        Cliente[] clienteArray = restTemplate.getForObject("http://localhost:5000/api/cliente", Cliente[].class);
        return Arrays.asList(clienteArray);
    }
}