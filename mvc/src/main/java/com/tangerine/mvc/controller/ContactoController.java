package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Mensaje;
import com.tangerine.mvc.model.Proyecto;
import com.tangerine.mvc.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase mapea las acciones a /mensajes
 */
@Controller
public class ContactoController {

    @Autowired
    MensajeService mensajeService;

    /**
     * Metodo recoge la peticion /contacto muestra la pagina contacto recogiendo un mensaje si es necesario.
     * @param mensaje
     * @return String con el nombre del archivo .html contacto.
     */
    @GetMapping(value="/contacto")
    public String showContacto(Mensaje mensaje){
        return "/frontoffice/contacto";
    }

    /**
     * Metodo recoge la peticion /contacto/success y muestra la pagina de contactogreeting.
     * @return String con el nombre del archivo .html contactogreeting.
     */
    @GetMapping(value="/contacto/success")
    public String showGreeting(){
        return "/frontoffice/contactogreeting";
    }

    /**
     * Metodo que recoge la petición /contacto/enviar guarda el mensaje en la BBDD y finalmente nos redirige al pagina /success.
     * @param mensaje
     * @return String con el nombre del archivo .html success.
     */
    @PostMapping(value="/contacto/enviar")
    public String mensajeEnviado(Mensaje mensaje){
        LocalDateTime now = LocalDateTime.now();
        mensaje.setFecha(Timestamp.valueOf(now));
        mensajeService.addMensaje(mensaje);
        return "redirect:/contacto/success";
    }

    /**
     * Metodo que recoge la petición /admin/mensajes y muestra todos los mensajes.
     * @param model
     * @return String con el nombre del archivo .html mensajes.
     */
    @GetMapping(value="/admin/mensajes")
    public String showMensajes(Model model) {

        List<Mensaje> mensajes = mensajeService.getMensajes();
        model.addAttribute("listamensajes", mensajes);

        return "backoffice/mensajes";
    }

    @PostMapping("/admin/mensajes")
    public ModelAndView respondMessage(Mensaje msg) {
        mensajeService.updateMensaje(msg);
        return new ModelAndView("redirect:/admin/mensajes");
    }

    @GetMapping(value="/admin/mensajes/{id}")
    public String showMensajeForm(@PathVariable Integer id, Model model) {
        Mensaje mensajeToRespond = mensajeService.getMensajeById(id);
        model.addAttribute("mensaje", mensajeToRespond);
        return "backoffice/mensajeForm";
    }


    @GetMapping(value="/admin/mensajes/delete/{id}")
    public String deleteMensaje(@PathVariable Integer id) {
        mensajeService.borrarMensaje(id);

        return "redirect:/admin/mensajes";
    }


}
