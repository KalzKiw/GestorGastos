const express = require('express');
const path = require('path');
const app = express();

// Servir archivos estáticos (CSS, JS, imágenes) desde la carpeta 'public'
app.use(express.static(path.join(__dirname, 'public')));

// Ruta para el Dashboard
app.get('/dashboard', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'dashboard.html'));
});

// Ruta para Movimientos
app.get('/movimientos', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'movimientos.html'));
});

// Ruta para Categorías
app.get('/categorias', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'categorias.html'));
});

// Ruta para Login
app.get('/login', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'login.html'));
});

// Ruta para Cerrar sesión
app.get('/logout', (req, res) => {
    res.send('Cerrar sesión'); // Lógica de cierre de sesión
});

// Configurar el puerto
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
