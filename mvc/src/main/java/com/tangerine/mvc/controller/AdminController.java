package com.tangerine.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    /**
     */
    @GetMapping("")
    public String getAllProyectos() {
        return "/backoffice/index";
    }
}
