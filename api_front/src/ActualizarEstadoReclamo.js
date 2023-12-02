import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormCambiarEstado from './Forms/FormCambiarEstado';
import Error from './Error';

function ActualizarEstadoReclamo() {

    const [error, setError] = useState(false);
    const [responseData, setResponseData] = useState(null);




    const handleSubmit = (datos) => {
        console.log(datos.newItem);
        // Realizar la solicitud POST al backend utilizando fetch
        fetch('http://localhost:8080/reclamo/cambiar/estado', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(datos.newItem),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Realizar acciones adicionales después de la inserción exitosa
                console.log('Elemento agregado exitosamente:', data);
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }// Rstablecer los campos del formularioe

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <div className="container mt-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <FormCambiarEstado onFormSubmit={handleSubmit} />
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

export default ActualizarEstadoReclamo;
