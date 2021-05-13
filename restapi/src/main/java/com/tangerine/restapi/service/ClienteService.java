package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Cliente;
import com.tangerine.restapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Victor Romero (Tangerine)
 * @version 0.0.1
 * Clase que se encarga de recoger las peticiones del controlador y solicitar al Repositorio
 * de clientes la accion pertinente
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    /**
     * Metodo que recupera una lista con los clientes en la base de datos
     *
     * @return List<Cliente>
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
