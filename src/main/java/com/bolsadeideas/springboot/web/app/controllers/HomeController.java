package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){        
        //redirije, recargando 2 veces pagina actual, pagina target
        //return "redirect:/app/index";
        //carga otra pagina sin modificar el url
        return "forward:/app/index";
    }
}