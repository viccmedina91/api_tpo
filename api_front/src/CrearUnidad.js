import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormCrearUnidad from './Forms/FormCrearUnidad';
import Error from './Error';

function CrearUnidad() {

    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);




    const handleSubmit = (datos) => {

        fetch(`http://localhost:8080/unidad/${datos.newItem.codigoEdificio}`, {
            method: 'POST',
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
                console.log('Elemento agregado exitosamente:', data);
                // Restablecer los campos del formulario

                setResponseData(data);
                console.log('..........');
                console.log(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }


            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (

        <div>
            <div className="container mt-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <h2>Crear Unidad</h2>
                        <FormCrearUnidad onFormSubmit={handleSubmit} />
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

export default CrearUnidad;
