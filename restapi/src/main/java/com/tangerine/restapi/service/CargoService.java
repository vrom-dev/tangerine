package com.tangerine.restapi.service;

import com.tangerine.restapi.model.Cargo;
import com.tangerine.restapi.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    CargoRepository cargoRepository;

    /**
     * Metodo que recupera una lista con los cargos en la base de datos
     *
     * @return List<Cliente>
     */
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }
}
