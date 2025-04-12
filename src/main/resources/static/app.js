const apiUrl = 'http://localhost:8080/api/movimientos'; // Cambia el URL según corresponda
fetch('/api/movimientos')
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));

// Obtener todos los movimientos
async function obtenerMovimientos() {
    try {
        const response = await fetch(apiUrl);
        const movimientos = await response.json();

        const movimientosList = document.getElementById('movimientos-list');
        movimientosList.innerHTML = ''; // Limpiar lista antes de mostrar los datos

        movimientos.forEach(movimiento => {
            const div = document.createElement('div');
            div.textContent = `${movimiento.tipo}: ${movimiento.cantidad} - ${movimiento.categoria} - ${movimiento.descripcion}`;
            movimientosList.appendChild(div);
        });
    } catch (error) {
        console.error('Error al obtener los movimientos:', error);
    }
}

// Añadir un nuevo movimiento
document.getElementById('formulario-movimiento').addEventListener('submit', async function (e) {
    e.preventDefault(); // Evita que el formulario recargue la página

    const tipo = document.getElementById('tipo').value;
    const cantidad = document.getElementById('cantidad').value;
    const categoria = document.getElementById('categoria').value;
    const descripcion = document.getElementById('descripcion').value;
    const fecha = document.getElementById('fecha').value;

    const nuevoMovimiento = {
        tipo,
        cantidad,
        categoria,
        descripcion,
        fecha
    };

    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoMovimiento)
        });

        if (response.ok) {
            obtenerMovimientos(); // Actualizar lista de movimientos
        } else {
            console.error('Error al añadir el movimiento');
        }
    } catch (error) {
        console.error('Error al hacer el POST:', error);
    }
});

// Cargar los movimientos al inicio
obtenerMovimientos();
document.getElementById("ingresar-btn").addEventListener("click", function() {
    const data = {
        tipo: "ingreso",
        cantidad: 100.50,
        categoria: "Comida",
        descripcion: "Cena",
        fecha: "2025-04-01"
    };

    fetch('http://localhost:8080/api/movimientos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => console.log('Movimiento creado:', data))
    .catch(error => console.error('Error:', error));
});

