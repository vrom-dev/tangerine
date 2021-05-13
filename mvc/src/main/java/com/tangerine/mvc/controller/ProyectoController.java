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

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;
    @Autowired
    ClienteService clienteService;

    private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

    @GetMapping("")
    public String getAllProyectos(Model model) {
        List<Proyecto> proyectos = proyectoService.getProyectos();
        model.addAttribute("listaproyectos", proyectos);
        return "/backoffice/proyectos";
    }

    //Le pasamos un model con la lista de clientes, y un proyecto vacío
    @GetMapping("/add")
    public String showProyectoForm(Model model, Proyecto proyecto) {
        List<Cliente> clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/backoffice/proyectoForm";
    }

    // Add proyecto
    @PostMapping("/add")
    public ModelAndView addProyecto(Proyecto proyecto) {
        proyectoService.addProyecto(proyecto);
        return new ModelAndView("redirect:/admin/proyectos");
    }

    //editar proyecto
    @GetMapping("/update/{id}")
    public String showProyectoToUpdate(@PathVariable Integer id, Model model) {
        List<Cliente> clientes = clienteService.getClientes();

        Proyecto proyecto = proyectoService.getById(id);
        model.addAttribute("clientes", clientes);
        model.addAttribute("proyecto", proyecto);
        return "/backoffice/proyectoFormEdit";
    }

    @PostMapping("/update")
    public ModelAndView editProyecto(Proyecto proyecto) {

        proyectoService.updateProyecto(proyecto);
        return new ModelAndView("redirect:/admin/proyectos");
    }

    //borra proyecto
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        //TO_BE_CHANGED.deleteById(id);
        return "";
    }

    //guardar proyecto
    @PostMapping("/save")
    public String saveUser() {
        return "";
    }
}
