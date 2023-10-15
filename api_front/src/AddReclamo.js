import React, { useState } from 'react';

function AddReclamo() {
    const [ubicacion, setUbicacion] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [documento, setDocumento] = useState('');
    const [codigo, setCodigo] = useState('');
    const [identificador, setIdentificador] = useState('');

    const handleUbicacionChange = (e) => {
        setUbicacion(e.target.value);
    };

    const handleDescripcionChange = (e) => {
        setDescripcion(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };

    const handleCodigoChange = (e) => {
        setCodigo(e.target.value);
    };

    const handleIdentificadorChange = (e) => {
        setIdentificador(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            ubicacion: ubicacion,
            descripcion: descripcion,
            documento: documento,
            codigo: codigo,
            identificador: identificador,
        };
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/reclamo/crear', {
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
                setDescripcion('');
                setUbicacion('');
                setDocumento('');
                setCodigo('');
                setIdentificador('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (
        <div>
            <h2>Agregar un Nuevo Reclamo</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="ubicacion">Ubicación:</label>
                    <input
                        type="text"
                        id="ubicacion"
                        value={ubicacion}
                        onChange={handleUbicacionChange}
                    />
                </div>
                <div>
                    <label htmlFor="descripcion">Descripcion:</label>
                    <input
                        type="text"
                        id="descripcion"
                        value={descripcion}
                        onChange={handleDescripcionChange}
                    />
                </div>
                <div>
                    <label htmlFor="documento">Documento:</label>
                    <input
                        type="text"
                        id="documento"
                        value={documento}
                        onChange={handleDocumentoChange}
                    />
                </div>
                <div>
                    <label htmlFor="codigo">Código Edificio:</label>
                    <input
                        type="text"
                        id="codigo"
                        value={codigo}
                        onChange={handleCodigoChange}
                    />
                </div>
                <div>
                    <label htmlFor="identificador">Número de Unidad:</label>
                    <input
                        type="text"
                        id="identificador"
                        value={identificador}
                        onChange={handleIdentificadorChange}
                    />
                </div>
                <button type="submit">Agregar</button>
            </form>
        </div>
    );
}

export default AddReclamo;
