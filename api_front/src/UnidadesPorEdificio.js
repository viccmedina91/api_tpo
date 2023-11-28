import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';

function UnidadesPorEdificio() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);
    const handleSubmit = (campo) => {
        // Busca un edificio según el código ingresado
        fetch(`http://localhost:8080/edificio/unidades/${campo}`)
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
            <h2>Listar Unidades de un Edificio</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default UnidadesPorEdificio;
