import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';
import Error from './Error';


function SearchInquilinoPorUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {
        // Devuelve la unidad según el identificador ingresado
        fetch(`http://localhost:8080/unidad/inquilinos/${campo}`)
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
                    <div className="col-md-6">
                        <h2>Buscar Inquilinos según Unidad</h2>
                        <FormSearch onSubmit={handleSubmit} />
                        {responseData && (
                            <div>
                                {error ? (
                                    <Error message={error} />
                                ) : <ShowList result={JSON.stringify(responseData, null, 2)} />}
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>

    );
}

export default SearchInquilinoPorUnidad;
