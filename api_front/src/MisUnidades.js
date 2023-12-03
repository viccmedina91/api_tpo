import React, { useState } from 'react';
import Error from './Error';
import TablaUnidades from './Tablas/TablaUnidades';


function MisUnidades() {
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleSubmit = () => {
        const documento = localStorage.getItem("documento");
        fetch(`http://localhost:8080/unidad/listar/${documento}`)
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
            <h2>Unidades</h2>
            <div className="container mt-3">
                <button type="button" class="btn btn-primary" onClick={handleSubmit}>
                    Listar Mis Unidades
                </button>
            </div>
            {responseData && (
                <div>
                    {error ? (
                        <Error message={error} />
                    ) : <TablaUnidades result={JSON.stringify(responseData, null, 2)} />}
                </div>
            )}
        </div>

    );
}

export default MisUnidades;
