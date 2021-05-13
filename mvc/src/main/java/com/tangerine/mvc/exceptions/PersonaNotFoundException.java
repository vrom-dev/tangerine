package com.tangerine.mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonaNotFoundException extends RuntimeException {

    public PersonaNotFoundException() {

        super("No existe un socio con ese id");
    }
}
