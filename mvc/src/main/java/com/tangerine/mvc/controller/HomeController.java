package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Persona;
import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.PersonaService;
import com.tangerine.mvc.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to map the incomming request for the home page and links in the home page
 */
@Controller
public class HomeController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    PersonaService personaService;

    /**
     * Home controller mapper, to map visits to the main page
     * @param model
     * @return String: Name of the main page HTML file
     */
    @GetMapping("/")
    public String showHome(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        List<Proyecto> newList = proyectos.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("listaproyectos", newList);
        return "/frontoffice/index";
    }

    /**
     * Proyectos Controller, to map GET request to proyectos website
     * @param model
     * @return String Name of the proyectos HTML file
     */
    @GetMapping("/proyectos")
    public String showProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        model.addAttribute("listaproyectos", proyectos);
        return "/frontoffice/proyectos";
    }

    /**
     * Socios Controller, to map GET request to socios website
     * @param model
     * @return String Name of the socios HTML file
     */
    @GetMapping("/socios")
    public String showCliente(Model model) {
        List<Persona> socios = personaService.getPersonas();
        List<Persona> fakeTeam = personaService.generateFakeMemberList(16);
        model.addAttribute("listasocios", socios);
        model.addAttribute("listafaketeam", fakeTeam);
        return "/frontoffice/socios";
    }

    @GetMapping("/jobs")
    public String showOfertas() {
        return "/frontoffice/jobs";
    }

}
