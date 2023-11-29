import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';


function SearchReclamoUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

    const handleSubmit = (campo) => {
        // Busca un edificio según el código ingresado
        fetch(`http://localhost:8080/reclamo/unidad/${campo}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                setResponseData(data);
                console.log(typeof (responseData));
            })
            .catch((error) => {
                console.error('Error al hacer la solicitud:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <h2>Buscar Reclamos según Unidad</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default SearchReclamoUnidad;
