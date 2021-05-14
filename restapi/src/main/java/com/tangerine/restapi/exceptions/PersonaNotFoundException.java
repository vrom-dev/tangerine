package com.tangerine.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Tangerine
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException() {
        /**
         * Excepcion con el mensaje de que no se ha encontrado un proyecto con ese id
         */
        super("No existe un socio con ese id");
    }
}
