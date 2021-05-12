package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Cliente;
import com.tangerine.restapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Autor     Es un metodo de comunicacion ,permite intercambiar informacion a traves de una red con la bbdd
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    /**
     * Lista a los clientes y los encuentra devolviendo la informacion de la BBDD
     * @return
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
