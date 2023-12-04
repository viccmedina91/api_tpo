import React, { useState } from 'react';
import ShowList from "./ShowList";
import FormSearch from './Forms/FormSearch';
import Error from './Error';
import BarraNavegacion from './BarraNavegacion';

function LiberarUnidad() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = (campo) => {

        fetch(`http://localhost:8080/unidad/liberar/${campo}`, {
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
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
            })
            .catch((error) => {
                console.error('Error al hacer la solicitud:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div>
            <div className="container mt-5">
                <div className="row">
                    <div className="col-4">
                        <BarraNavegacion />
                    </div>
                    <div className="col-8">
                        <h2>Liberar Unidad</h2>
                        <FormSearch onSubmit={handleSubmit} />
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

export default LiberarUnidad;
