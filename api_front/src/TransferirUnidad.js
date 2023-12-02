import React, { useState } from 'react';
import ShowList from "./ShowList";
import Error from './Error';


function TransferirUnidad() {
    const [documentoPersona, setDocumentoPersona] = useState('');
    const [numeroUnidad, setNumeroUnidad] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleDocumentoPersonaChange = (e) => {
        setDocumentoPersona(e.target.value);
    };

    const handleNumeroChange = (e) => {
        setNumeroUnidad(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            documento: documentoPersona,
            codigoUnidad: numeroUnidad
        };
        fetch('http://localhost:8080/unidad/transferir/unidad', {
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
                console.log('Elemento agregado exitosamente:', data);
                // Restablecer los campos del formulario
                console.log(data.mensaje);
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
                setDocumentoPersona('');
                setNumeroUnidad('');

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
                    <h2> Formulario para crear una Unidad </h2>
                    <form onSubmit={handleSubmit}>

                        <div className="mb-3">
                            <label htmlFor="Documento Persona" className="form-label">Documento</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={documentoPersona}
                                onChange={handleDocumentoPersonaChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Numero" className="form-label">Número</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={numeroUnidad}
                                onChange={handleNumeroChange}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
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
export default TransferirUnidad;
