import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';

function HabitarUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(null);

    const handleSubmit = (campo) => {

        fetch(`http://localhost:8080/unidad/habitar/${campo}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(campo),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                setResponseData(data);
            })
            .catch((error) => {
                console.error('Error al hacer la solicitud:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <h2>Habitar Unidad</h2>
            <FormSearch onSubmit={handleSubmit} />
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
            {error && <p className="text-danger mt-3">{error}</p>}
        </div>
    );
}

export default HabitarUnidad;
