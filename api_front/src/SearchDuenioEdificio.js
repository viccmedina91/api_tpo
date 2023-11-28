import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';

function SearchDuenioEdificio() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);
    const handleSubmit = (campo) => {
        // Según el código de Edificio ingresado, devuelve todos los dueños
        fetch(`http://localhost:8080/edificio/duenios/${campo}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Manejar la respuesta del backend, esto no se que hace, preguntar
                setResponseData(data);
            })
            .catch((error) => {
                console.error('Error al hacer la solicitud:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <h2>Buscar Dueño según Edificio</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default SearchDuenioEdificio;
