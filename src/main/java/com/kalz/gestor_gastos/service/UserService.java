package com.kalz.gestor_gastos.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Método para autenticar el usuario
    public boolean authenticate(String username, String password) {
        // Aquí se verifican las credenciales (puedes hacer una consulta a la base de datos)
        // Como ejemplo, vamos a asumir que el usuario "admin" y contraseña "admin" son válidos.

        return "admin".equals(username) && "admin".equals(password);
    }
}

