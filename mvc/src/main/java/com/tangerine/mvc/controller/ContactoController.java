package com.tangerine.mvc.controller;

import com.tangerine.mvc.model.Mensaje;
import com.tangerine.mvc.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    MensajeService mensajeService;

    @GetMapping(value="/contacto")
    public String showContacto(Mensaje mensaje){
        return "/frontoffice/contacto";
    }

    @GetMapping(value="/contacto/success")
    public String showGreeting(){
        return "/frontoffice/contactogreeting";
    }

    @PostMapping(value="/contacto/enviar")
    public String mensajeEnviado(Mensaje mensaje){
        LocalDateTime now = LocalDateTime.now();
        mensaje.setFecha(Timestamp.valueOf(now));
        mensajeService.addMensaje(mensaje);
        return "redirect:/contacto/success";
    }

    @GetMapping(value="/admin/mensajes")
    public String showMensajes(Model model) {

        List<Mensaje> mensajes = mensajeService.getMensajes();
        model.addAttribute("listamensajes", mensajes);

        return "backoffice/mensajes";
    }


}
