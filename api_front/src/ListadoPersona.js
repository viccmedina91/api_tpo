import React, { useState } from 'react';
import TablaPersonas from './Tablas/TablaPersonas';

function ListadoPersona() {
    const [responseData, setResponseData] = useState(null);

    const handleSubmit = () => {
        // Devuelve todos los edificios cargados en la BD.
        fetch(`http://localhost:8080/persona/listar`)
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
            <button onClick={handleSubmit}>Listar</button>

            {responseData && (<TablaPersonas result={JSON.stringify(responseData, null, 2)} />
            )}
        </div>
    );
}

export default ListadoPersona;
