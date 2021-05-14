package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Cliente;
import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.ClienteService;
import com.tangerine.mvc.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Class to map all actios performed by admin over proyectos site
 */
@Controller
@RequestMapping("/admin/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;
    @Autowired
    ClienteService clienteService;

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    /**
     * Method to show all proyects in the page admin/proyectos
     *
     * @param model
     * @return String with the name of the HTML file proyectos
     */
    @GetMapping("")
    public String getAllProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        model.addAttribute("listaproyectos", proyectos);
        return "/backoffice/proyectos";
    }

    /**
     * Method to show the form to add a new proyect
     *
     * @param model
     * @param proyecto
     * @return String with the name of the HTML file containing the form
     */
    //Le pasamos un model con la lista de clientes, y un proyecto vacío
    @GetMapping("/add")
    public String showProyectoForm(Model model, Proyecto proyecto) {
        List<Cliente> clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/backoffice/proyectoForm";
    }

    /**
     * Method to send to the api the iformation of the new proyect to be added (POST)
     *
     * @param proyecto
     * @return
     */
    @PostMapping("/add")
    public ModelAndView addProyecto(Proyecto proyecto) {
        proyectoService.addProyecto(proyecto);
        return new ModelAndView("redirect:/admin/proyectos");
    }


    /**
     * Method to show the form to edit a proyect with the information of that proyect populated.
     * The proyect id selected in the previous page, admin/proyectos
     *
     * @param id
     * @param model
     * @return String with the name of the HTML file with the form to edit a proyect
     */
    @GetMapping("/update/{id}")
    public String showProyectoToUpdate(@PathVariable Integer id, Model model) {
        List<Cliente> clientes = clienteService.getClientes();

        Proyecto proyecto = proyectoService.getById(id);
        model.addAttribute("clientes", clientes);
        model.addAttribute("proyecto", proyecto);
        return "/backoffice/proyectoFormEdit";
    }

    /**
     * Method to send to the api the information to edit a proyect from the edit form (POST)
     *
     * @param proyecto
     * @return
     */
    @PostMapping("/update")
    public ModelAndView editProyecto(Proyecto proyecto) {

        proyectoService.updateProyecto(proyecto);
        return new ModelAndView("redirect:/admin/proyectos");
    }

    //borra proyecto
    @GetMapping("/{id}")
    public String borrarProyecto(@PathVariable Integer id) {
        proyectoService.borrarProyecto(id);
        return "redirect:/admin/Proyectos";
    }

}
