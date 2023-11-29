import React, { useState } from 'react';
import ShowList from "./ShowList";

function ActualizarEstadoReclamo() {
    const [reclamoid, setReclamoid] = useState('');
    const [estado, setEstado] = useState('');
    const [error, setError] = useState(null);
    const [responseData, setResponseData] = useState(null);

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
            numero: reclamoid,
            estado: estado,
        };
        console.log(newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/reclamo/cambiar/estado', {
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
                setReclamoid('');
                setEstado('');
                setResponseData(data);
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
                    <h2> Actualizar Estado a Reclamo </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Nro de Reclamo" className="form-label">Nro de Reclamo</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={reclamoid}
                                onChange={handleReclamoidChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Estado" className="form-label">Estado</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={estado}
                                onChange={handleEstadoChange}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default ActualizarEstadoReclamo;
