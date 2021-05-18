package com.tangerine.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase que mapea todas las acciones a traves de admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    /**
     * Metodo que muestra la web index
     * @return String con el nombre del archivo .html index.
     */
    @GetMapping("")
    public String showIndex() {
        return "/backoffice/index";
    }
}
