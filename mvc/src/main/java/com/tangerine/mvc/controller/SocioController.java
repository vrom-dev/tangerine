package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Persona;
import com.tangerine.mvc.service.CargoService;
import com.tangerine.mvc.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/socios")
public class SocioController {
    @Autowired
    PersonaService personaService;
    @Autowired
    CargoService cargoService;

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    @GetMapping("")
    public String getAllProyectos(Model model) {
        List<Persona> socios = personaService.getPersonas();
        model.addAttribute("listasocios", socios);
        return "/backoffice/socios";
    }
    //borra socio
    @GetMapping("/delete/{id}")
    public String borrarSocio(@PathVariable Integer id) {
        personaService.borrarSocio(id);
        return "redirect:/admin/socios";
    }
}
