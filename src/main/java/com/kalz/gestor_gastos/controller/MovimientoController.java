package com.kalz.gestor_gastos.controller;

import com.kalz.gestor_gastos.model.Movimiento;
import com.kalz.gestor_gastos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    // Crear un nuevo movimiento
    @PostMapping
    public ResponseEntity<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = movimientoService.crearMovimiento(movimiento);
        return new ResponseEntity<>(nuevoMovimiento, HttpStatus.CREATED);
    }

    // Obtener todos los movimientos
    @GetMapping
    public List<Movimiento> obtenerTodosMovimientos() {
        return movimientoService.obtenerTodosMovimientos();
    }

    // Obtener un movimiento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable Long id) {
        Optional<Movimiento> movimiento = movimientoService.obtenerMovimientoPorId(id);
        return movimiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Obtener movimientos de un usuario específico
    @GetMapping("/usuario/{usuarioId}")
    public List<Movimiento> obtenerMovimientosPorUsuario(@PathVariable Long usuarioId) {
        return movimientoService.obtenerMovimientosPorUsuario(usuarioId);
    }
}
