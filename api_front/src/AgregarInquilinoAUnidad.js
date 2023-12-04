import React, { useState } from 'react';
import ShowList from "./ShowList";
import Error from './Error';
import BarraNavegacion from './BarraNavegacion';

function AgregarInquilinoAUnidad() {
    const [codigoUnidad, setCodigoUnidad] = useState('');
    const [documento, setDocumento] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

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
        fetch('http://localhost:8080/unidad/agregar/inquilino', {
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
                console.log('Elemento agregado exitosamente:', data);
                setResponseData(data);
                setDocumento('');
                setCodigoUnidad('');
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }

            })
            .catch((error) => {
                setError(error.mensaje);
                console.error('Error al agregar el elemento:', error);
            });
    };
    return (

        <div className="container mt-5">
            <div className="row">
                <div className="col-4">
                    <BarraNavegacion />
                </div>
                <div className="col-8">
                    <h2> Formulario para agregar Inquilino a Unidad </h2>
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
                    <br></br>
                </div>
            </div>
            {responseData && (
                <div>
                    {error ? (
                        <Error message={error} />
                    ) : <ShowList result={JSON.stringify(responseData, null, 2)} />}
                </div>
            )}
        </div>
    );
}

export default AgregarInquilinoAUnidad;
