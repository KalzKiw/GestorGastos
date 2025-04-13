package com.kalz.gestor_gastos.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Método de autenticación básico
    public boolean authenticate(String username, String password) {
        // Aquí deberías implementar tu lógica de autenticación
        // En un caso real, probablemente comprobarías la base de datos o algún repositorio
        // Esto es solo un ejemplo básico:
        return "admin".equals(username) && "password".equals(password);  // Cambia por tu lógica real
    }
}
