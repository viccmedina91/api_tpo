import React, { useState } from 'react';
import TablaUnidades from './Tablas/TablaUnidades';
import FormSearch from './Forms/FormSearch';
import Error from './Error';

function SearchUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {
        // Devuelve la unidad según el identificador ingresado
        fetch(`http://localhost:8080/unidad/${campo}`)
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
                <div className="row justify-content-center">
                    <div className="col-md-6"></div>
                    <h2>Buscar Unidad según Identificador</h2>
                    <FormSearch onSubmit={handleSubmit} />
                    {responseData && (
                        <div>
                            {error ? (
                                <Error message={error} />
                            ) : <TablaUnidades result={JSON.stringify(responseData, null, 2)} />}
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

export default SearchUnidad;
