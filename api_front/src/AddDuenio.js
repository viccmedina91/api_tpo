import React, { useState } from 'react';

function AddDuenio() {
    const [identificador, setIdentificador] = useState('');
    const [nombre, setNombre] = useState('');
    const [documento, setDocumento] = useState('');
    const [mail, setMail] = useState('');
    const [contrasenia, setContrasenia] = useState('');

    const handleIdentificadorChange = (e) => {
        setIdentificador(e.target.value);
    };

    const handleNombreChange = (e) => {
        setNombre(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };

    const handleMailChange = (e) => {
        setMail(e.target.value);
    };

    const handleContraseniaChange = (e) => {
        setContrasenia(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            identificador: identificador,
            nombre: nombre,
            documento: documento,
            contrasenia: contrasenia,
            mail: mail,
        };
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/duenio/crear', {
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
                setIdentificador('');
                setNombre('');
                setDocumento('');
                setContrasenia('');
                setMail('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (
        <div>
            <h2>Agregar un Nuevo Dueño</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="Nombre">Nombre:</label>
                    <input
                        type="text"
                        id="nombre"
                        value={nombre}
                        onChange={handleNombreChange}
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
                    <label htmlFor="mail">Mail:</label>
                    <input
                        type="text"
                        id="mail"
                        value={mail}
                        onChange={handleMailChange}
                    />
                </div>
                <div>
                    <label htmlFor="contrasenia">Contraseña:</label>
                    <input
                        type="text"
                        id="contrasenia"
                        value={contrasenia}
                        onChange={handleContraseniaChange}
                    />
                </div>
                <div>
                    <label htmlFor="identidicador">Número de Unidad:</label>
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

export default AddDuenio;
