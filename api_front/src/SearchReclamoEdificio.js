import React, { useState } from 'react';
import TablaReclamos from "./Tablas/TablaReclamos";
import Error from "./Error";
import FormSearch from './Forms/FormSearch';
import BarraNavegacion from './BarraNavegacion';

function SearchReclamoEdificio() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {
        // Busca un edificio según el código ingresado
        fetch(`http://localhost:8080/reclamo/edificio/${campo}`)
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
            })
            .catch((error) => {
                setError(error.mensaje);
                console.error('Error al hacer la solicitud:', error);
            });
    };
    return (
        <div>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-4">
                        <BarraNavegacion />
                    </div>
                    <div className="col-8">
                        <h2>Listar Reclamos por Edificio</h2>
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

                    ) : <TablaReclamos result={JSON.stringify(responseData, null, 2)} />}
                </div>
            )}
        </div>
    );
}

export default SearchReclamoEdificio;
