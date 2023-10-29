import React, { useState } from 'react';

function AddImagen() {
    const [reclamoid, setReclamoID] = useState('');
    const [path, setPath] = useState('');
    const [tipo, setTipo] = useState('');


    const handleReclamoChange = (e) => {
        setReclamoID(e.target.value);
    };

    const handlePathChange = (e) => {
        setPath(e.target.value);
    };

    const handleTipoChange = (e) => {
        setTipo(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            reclamoid: reclamoid,
            path: path,
            tipo: tipo,

        };
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/imagenes/crear', {
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
                setReclamoID('');
                setPath('');
                setTipo('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (
        <div>
            <h2>Agregar Imagen a Reclamo</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="reclamoid">Nro. Reclamo:</label>
                    <input
                        type="number"
                        id="reclamoid"
                        value={reclamoid}
                        onChange={handleReclamoChange}
                    />
                </div>
                <div>
                    <label htmlFor="path">Path:</label>
                    <input
                        type="text"
                        id="path"
                        value={path}
                        onChange={handlePathChange}
                    />
                </div>
                <div>
                    <label htmlFor="tipo">Tipo:</label>
                    <input
                        type="text"
                        id="tipo"
                        value={tipo}
                        onChange={handleTipoChange}
                    />
                </div>
                <button type="submit">Agregar</button>
            </form>
        </div>
    );
}

export default AddImagen;
