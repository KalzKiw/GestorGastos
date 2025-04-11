package com.kalz.gestor_gastos.service;

import com.kalz.gestor_gastos.model.Movimiento;
import com.kalz.gestor_gastos.model.Usuario;
import com.kalz.gestor_gastos.repository.MovimientoRepository;
import com.kalz.gestor_gastos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Movimiento crearMovimiento(Movimiento movimiento, Long usuarioId) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            movimiento.setUsuario(usuario);
            return movimientoRepository.save(movimiento);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public List<Movimiento> obtenerTodosMovimientos() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id);
    }

    public List<Movimiento> obtenerMovimientosPorUsuario(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        return usuario.map(movimientoRepository::findByUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
