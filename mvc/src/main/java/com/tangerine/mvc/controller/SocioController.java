package com.tangerine.mvc.controller;

import com.tangerine.mvc.service.CargoService;
import com.tangerine.mvc.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class SocioController {
    @Autowired
    PersonaService personaService;
    @Autowired
    CargoService cargoService;




}
