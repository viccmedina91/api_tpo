import React, { useState } from 'react';
import ShowList from "./ShowList";
import Error from './Error';

function ModificarPersona() {
    const [nombre, setNombre] = useState('');
    const [mail, setMail] = useState('');
    const [documento, setDocumento] = useState('');
    const [contrasenia, setContrasenia] = useState('');
    const [error, setError] = useState(null);
    const [responseData, setResponseData] = useState(null);

    const handleNombreChange = (e) => {
        setNombre(e.target.value);
    };

    const handleMailChange = (e) => {
        setMail(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };

    const handleContraseniaChange = (e) => {
        setContrasenia(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            nombre: nombre,
            mail: mail,
            contrasenia: contrasenia,
        };
        console.log(newItem);
        fetch(`http://localhost:8080/persona/${documento}`, {
            method: 'PUT',
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
                setResponseData(data);
                setDocumento('');
                setNombre('');
                setMail('');
                setContrasenia('');
            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <h2> Formulario para modificar una Persona</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Documento" className="form-label">Documento</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={documento}
                                onChange={handleDocumentoChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Nombre" className="form-label">Nombre</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={nombre}
                                onChange={handleNombreChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Mail" className="form-label">Mail</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={mail}
                                onChange={handleMailChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Contraseña" className="form-label">Contraseña</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={contrasenia}
                                onChange={handleContraseniaChange}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                    {responseData && (
                        <div>
                            {error ? (
                                <Error message={error} />
                            ) : <ShowList result={JSON.stringify(responseData, null, 2)} />}
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

export default ModificarPersona;
