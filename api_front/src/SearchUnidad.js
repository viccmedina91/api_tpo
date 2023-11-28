import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';


function SearchUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

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
                // Manejar la respuesta del backend, esto no se que hace, preguntar
                setResponseData(data);
                console.log(typeof (responseData));
            })
            .catch((error) => {
                setError(error.mensaje);
                console.error('Error al hacer la solicitud:', error);
            });
    };

    return (
        <div>
            <h2>Buscar Unidad según Identificador</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default SearchUnidad;
