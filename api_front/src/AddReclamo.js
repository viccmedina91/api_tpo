import React, { useState } from 'react';
import ShowList from "./ShowList";

function AddReclamo() {
    const [ubicacion, setUbicacion] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [documento, setDocumento] = useState('');
    const [codigo, setCodigo] = useState('');
    const [identificador, setIdentificador] = useState('');
    const [error, setError] = useState(null);
    const [responseData, setResponseData] = useState(null);

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
        fetch('http://localhost:8080/reclamo', {
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
                setResponseData(data);
                setDescripcion('');
                setUbicacion('');
                setDocumento('');
                setCodigo('');
                setIdentificador('');

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
                    <h2> Formulario para agregar un Reclamo</h2>
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
                            <label htmlFor="Código Edificio" className="form-label">Código Edificio</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={codigo}
                                onChange={handleCodigoChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Ubicación" className="form-label">Ubicación</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={ubicacion}
                                onChange={handleUbicacionChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Descripción" className="form-label">Descripción</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={descripcion}
                                onChange={handleDescripcionChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Identificador Unidad" className="form-label">Identificador Unidad</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={identificador}
                                onChange={handleIdentificadorChange}
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

export default AddReclamo;
