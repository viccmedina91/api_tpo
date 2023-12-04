import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormAgregarImagen from './Forms/FormAgregarImagen';
import Error from './Error';

function AddImagen() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = async (datos) => {
        fetch(`http://localhost:8080/reclamo/agregar/imagen/${datos.newItem.reclamoid}`, {
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
                }
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
                        <h2>Agregar Imagen a Reclamo</h2>
                        <FormAgregarImagen onFormSubmit={handleSubmit} />
                        <br></br>
                        {responseData && (
                            <div>
                                {error ? (
                                    <Error message={error} />
                                ) : <ShowList result={JSON.stringify(responseData.mensaje, null, 2)} />}
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AddImagen;
