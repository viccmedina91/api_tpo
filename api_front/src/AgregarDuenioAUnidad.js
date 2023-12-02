import React, { useState } from 'react';
import ShowList from "./ShowList";
import Error from './Error';

function AgregarDuenioAUnidad() {
    const [codigoUnidad, setCodigoUnidad] = useState('');
    const [documento, setDocumento] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

    const handleCodigoUnidadChange = (e) => {
        setCodigoUnidad(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            documento: documento,
            codigoUnidad: codigoUnidad,

        };
        console.log(newItem);
        fetch('http://localhost:8080/unidad/agregar/duenio', {
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
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
                setDocumento('');
                setCodigoUnidad('');

            })
            .catch((error) => {
                setError(error.mensaje);
                console.error('Error al agregar el elemento:', error);
            });
    };
    return (

        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <h2> Formulario para agregar Dueños a Unidad </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Código de Unidad" className="form-label">Indentificador Unidad</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={codigoUnidad}
                                onChange={handleCodigoUnidadChange}
                                required
                            />
                        </div>
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
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                    {responseData && (
                        <div>
                            {error ? (
                                <Error message={error} />
                            ) : <ShowList result={JSON.stringify(responseData.mensaje, null, 2)} />}
                        </div>

                    )}
                </div>
            </div>
        </div>
    );
}

export default AgregarDuenioAUnidad;
