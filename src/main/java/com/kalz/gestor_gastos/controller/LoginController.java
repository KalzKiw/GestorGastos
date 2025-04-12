package com.kalz.gestor_gastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;  // Un servicio para autenticar usuarios

    // Constructor para inyectar el servicio de usuario
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;  // Un servicio para autenticar usuarios

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        // Verificar las credenciales del usuario
        boolean isAuthenticated = userService.authenticate(username, password);

        if (isAuthenticated) {
            session.setAttribute("username", username);  // Guardamos la sesión
            return "redirect:/dashboard";  // Redirige al dashboard
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";  // Regresa al formulario de login con un mensaje de error
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Retorna la vista del login
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";  // Si no está autenticado, redirige al login
        }
        return "dashboard";  // Muestra la vista del dashboard
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalida la sesión
        return "redirect:/login";  // Redirige al login
    }
}
