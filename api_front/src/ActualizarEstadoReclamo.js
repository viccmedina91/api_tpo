import React, { useState } from 'react';

function ActualizarEstadoReclamo() {
    const [reclamoid, setReclamoid] = useState('');
    const [estado, setEstado] = useState('');


    const handleReclamoidChange = (e) => {
        setReclamoid(e.target.value);
    };

    const handleEstadoChange = (e) => {
        setEstado(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            reclamoid: reclamoid,
            estado: estado,
        };
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/reclamo/actualizar/estado', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newItem),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Realizar acciones adicionales después de la inserción exitosa
                console.log('Elemento agregado exitosamente:', data);
                // Restablecer los campos del formulario
                setReclamoid('');
                setEstado('');
            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (
        <div>
            <h2>Actualizar estado de Reclamo</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="Reclamoid">Nro Reclamo:</label>
                    <input
                        type="number"
                        id="reclamoid"
                        value={reclamoid}
                        onChange={handleReclamoidChange}
                    />
                </div>
                <div>
                    <label htmlFor="estado">Estado:</label>
                    <input
                        type="text"
                        id="estado"
                        value={estado}
                        onChange={handleEstadoChange}
                    />
                </div>
                <button type="submit">Actualizar</button>
            </form>
        </div>
    );
}

export default ActualizarEstadoReclamo;
