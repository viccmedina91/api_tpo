import React, { useState } from 'react';
import FormSearch from './Forms/FormSearch';
import Error from './Error';
import TablaPersonas from './Tablas/TablaPersonas';
import BarraNavegacion from './BarraNavegacion';

function SearchInquilinoEdificio() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {
        // // Según el código de Edificio ingresado, devuelve todos los Inquilinos
        fetch(`http://localhost:8080/edificio/habitantes/${campo}`)
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
                console.error('Error al hacer la solicitud:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-4">
                        <BarraNavegacion usuario={localStorage.getItem('documento')} />
                    </div>
                    <div className="col-8">
                        <h2>Listar Inquilinos según Edificio</h2>
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
                                </div>
                            </div>
                        </div>
                    ) : <TablaPersonas result={JSON.stringify(responseData, null, 2)} />}
                </div>
            )}
        </div>
    );
}

export default SearchInquilinoEdificio;
