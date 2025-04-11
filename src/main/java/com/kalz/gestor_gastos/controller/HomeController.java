package com.kalz.gestor_gastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido al Gestor de Gastos!");
        return "index";  // Thymeleaf buscará index.html en templates
    }
}

