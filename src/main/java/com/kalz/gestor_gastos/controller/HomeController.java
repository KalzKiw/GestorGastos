package com.kalz.gestor_gastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Página de inicio (index)
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido al Gestor de Gastos!");
        return "index";  // Busca index.html en /templates
    }

    // Página principal (login)
    @GetMapping("/")
    public String showLogin() {
        return "login";  // Busca login.html en /templates
    }

    // Procesar el login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Aquí deberías validar las credenciales (puedes hacerlo de una manera simple para este ejemplo)
        if ("admin".equals(username) && "1234".equals(password)) {
            return "redirect:/dashboard";  // Redirige al dashboard si las credenciales son correctas
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");  // Agrega un mensaje de error
            return "login";  // Vuelve a la página de login si las credenciales son incorrectas
        }
    }

    // Página de bienvenida con mensaje
    @GetMapping("/inicio")
    public String home(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido al Gestor de Gastos!");
        return "index";  // Busca index.html en /templates
    }

    // Dashboard tras iniciar sesión
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";  // Busca dashboard.html en /templates
    }
}
