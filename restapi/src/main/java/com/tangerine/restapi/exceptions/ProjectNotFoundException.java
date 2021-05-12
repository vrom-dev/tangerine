package com.tangerine.restapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Victor Romero (Tangerine)
 * @version 0.0.1
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends RuntimeException {
    /**
     * Excepcion con el mensaje de que no se ha encontrado un proyecto con ese id
     */
    public ProjectNotFoundException() {
        super("No existe un proyecto con este id");
    }
}
