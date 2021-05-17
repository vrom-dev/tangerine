package com.tangerine.mvc.service;
/**
 * @Author Alberto (Tangerine)
 */

import com.tangerine.mvc.model.Cargo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Creación de una clase service llamada CargoService
 */
@Service
public class CargoService {
    /**
     * Metodo que hace una petecion a la apirest que devuelve una lista de cargos
     *
     * @return lista de cargos
     */
    public List<Cargo> getCargos() {
        RestTemplate restTemplate = new RestTemplate();
        Cargo[] cargoArray = restTemplate.getForObject("http://localhost:5000/api/cargo", Cargo[].class);
        return Arrays.asList(cargoArray);
    }

}
