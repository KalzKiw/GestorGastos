package com.kalz.gestor_gastos.repository;

import com.kalz.gestor_gastos.model.Movimiento;
import com.kalz.gestor_gastos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByUsuario(Usuario usuario);
}
