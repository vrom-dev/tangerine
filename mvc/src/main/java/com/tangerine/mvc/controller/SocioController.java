package com.tangerine.mvc.controller;
/**
 * @Author Alberto (Tangerine)
 */

import com.tangerine.mvc.model.Cargo;
import com.tangerine.mvc.model.Cliente;
import com.tangerine.mvc.model.Persona;
import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.CargoService;
import com.tangerine.mvc.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Clock;
import java.util.List;

/**
 * Clase que mapea todas las acciones atraves de admin sobre socios.
 */
@Controller
@RequestMapping("/admin/socios")
public class SocioController {
    @Autowired
    PersonaService personaService;
    @Autowired
    CargoService cargoService;

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    /**
     * Metodo que muestra todos los socios en la pagina /admin/socios
     *
     * @param model
     * @return String con nombre del archivo .html que contiene la lista de socios.
     */
    @GetMapping("")
    public String getAllProyectos(Model model) {
        List<Persona> socios = personaService.getPersonas();
        model.addAttribute("listasocios", socios);
        return "/backoffice/socios";
    }

    /**
     * Metodo que muestra formulario correspondiente para crear un nuevo socio.
     * Se envia un model con la lista de cargos y un objeto "persona" vacio.
     *
     * @param model
     * @param persona
     * @return String con el nombre del archivo .html que contiene el formulario.
     */
    @GetMapping("/add")
    public String showSocioForm(Model model, Persona persona) {
        List<Cargo> cargos = cargoService.getCargos();
        model.addAttribute("cargos", cargos);
        return "/backoffice/socioForm";
    }

    /**
     * Metodo que envia a la api la informacion del nuevo socio que queremos crear
     * @param persona
     */
    @PostMapping("/add")
    public ModelAndView addSocio(Persona persona) {
        personaService.addPersona(persona);
        return new ModelAndView("redirect:/admin/socios");
    }

    /**Metodo que muestra la informacion del socio a editar en un formulario.
     * Metodo
     * @param id
     * @param model
     * @return String con el nombre del archivo .html que contiene el formulario para editar el socio seleccionado.
     */
    @GetMapping("/update/{id}")
    public String showSocioToUpdate(@PathVariable Integer id, Model model) {
        List<Cargo> cargos = cargoService.getCargos();
        Persona persona = personaService.getById(id);
        model.addAttribute("cargos", cargos);
        model.addAttribute("persona", persona);
        return "/backoffice/socioFormEdit";
    }

    /**
     * Metodo para enviar a la api la informacion del socio editado.
     * @param persona
     * @return
     */
    @PostMapping("/update")
    public ModelAndView editSocio(Persona persona) {
        personaService.editSocio(persona);
        return new ModelAndView("redirect:/admin/socios");
    }

    /**
     * Metodo que borra el socio mediante un id.
     * @param id
     * @return redirige a la pagina de socios con el cambio efectuado.
     */
    //borra socio
    @GetMapping("/delete/{id}")
    public String borrarSocio(@PathVariable Integer id) {
        personaService.borrarSocio(id);
        return "redirect:/admin/socios";

    }
}

