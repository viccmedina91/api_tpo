import React, { useState } from 'react';
import FormSearch from './Forms/FormSearch';
import Error from './Error';
import TablaPersonas from './Tablas/TablaPersonas';

function HabilitadosPorEdificio() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);
    const handleSubmit = (campo) => {
        // Busca un edificio según el código ingresado
        fetch(`http://localhost:8080/edificio/habilitados/${campo}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Manejar la respuesta del backend, esto no se que hace, preguntar
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
            })
            .catch((error) => {
                setError(error.mensaje);
                console.error('Error al hacer la solicitud:', error);
            });
    };

    return (
        <div>
            <div className="container mt-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <h2>Buscar Habilitados según Edificio</h2>
                        <FormSearch onSubmit={handleSubmit} />

                    </div>
                </div>
            </div>

            {responseData && (
                <div>
                    {error ? (
                        <div className="container mt-5">
                            <div className="row justify-content-center">
                                <div className="col-md-6">
                                    <Error message={error} />
                                </div></div></div>
                    ) : <TablaPersonas result={JSON.stringify(responseData, null, 2)} />}
                </div>
            )}
        </div>
    );
}

export default HabilitadosPorEdificio;
