import React, { useState } from 'react';
import ShowList from "./ShowList";

function AddImagen() {
    const [reclamoid, setReclamoID] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);
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
        fetch(`http://localhost:8080/reclamo/agregar/imagen/${reclamoid}`, {
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
                setReclamoID('');
                setPath('');
                setTipo('');

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
                    <h2> Agregar Imagen a Reclamo </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Nro de Reclamo" className="form-label">Nro de Reclamo</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={reclamoid}
                                onChange={handleReclamoChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Tipo" className="form-label">Tipo</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={tipo}
                                onChange={handleTipoChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Path" className="form-label">Path de Imagen</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={path}
                                onChange={handlePathChange}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
        </div>
    );
}

export default AddImagen;
