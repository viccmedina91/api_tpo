import React, { useState } from 'react';
import FormSearch from './Forms/FormSearch';
import Error from './Error';
import TablaReclamos from './Tablas/TablaReclamos';
import BarraNavegacion from './BarraNavegacion';

function SearchReclamo() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {
        // Devuelve el reclamo según el identificador que enviemos
        fetch(`http://localhost:8080/reclamo/${campo}`)
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
                        <h2>Buscar Reclamo por Nro</h2>
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

export default SearchReclamo;
