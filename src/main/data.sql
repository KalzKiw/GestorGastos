-- Insertar usuario de prueba
INSERT INTO usuario (id, nombre, email, contraseña)
VALUES (1, 'Kalz', 'kalz@example.com', '1234');

-- Insertar movimientos de ejemplo
INSERT INTO movimiento (id, tipo, cantidad, categoria, descripcion, fecha, usuario_id)
VALUES
  (1, 'ingreso', 1500.00, 'salario', 'Nómina mensual', CURRENT_DATE, 1),
  (2, 'gasto', 200.00, 'comida', 'Compra supermercado', CURRENT_DATE, 1);
