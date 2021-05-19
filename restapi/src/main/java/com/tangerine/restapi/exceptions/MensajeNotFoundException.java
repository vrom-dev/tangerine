package com.tangerine.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author Tangerine
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MensajeNotFoundException extends RuntimeException {

    public MensajeNotFoundException() {
        /**
         * Excepcion con el mensaje de que no se ha encontrado un mensaje con ese id
         */
        super("No existe un mensaje con ese id");
    }
}