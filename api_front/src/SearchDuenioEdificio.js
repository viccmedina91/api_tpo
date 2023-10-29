import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';

function SearchDuenioEdificio() {
    const [responseData, setResponseData] = useState(null);

    const handleSubmit = (campo) => {
        // Según el código de Edificio ingresado, devuelve todos los dueños
        fetch(`http://localhost:8080/duenio/edificio/${campo}`)
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
                console.error('Error al hacer la solicitud:', error);
            });
    };

    return (
        <div>
            <h2>Buscar Dueño según Edificio</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
        </div>
    );
}

export default SearchDuenioEdificio;
