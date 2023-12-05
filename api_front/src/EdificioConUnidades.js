import React, { useState } from 'react';
import TablaEdificiosUnidad from './Tablas/TablaEdificioUnidad';
import BarraNavegacion from './BarraNavegacion';

function EdificioConUnidades() {
    const [responseData, setResponseData] = useState(null);

    const handleSubmit = () => {
        // Devuelve todos los edificios y sus unidades cargados en la BD.
        fetch(`http://localhost:8080/edificio/con/unidades`)
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
            <div className="container mt-5">
                <div className="row">
                    <div className="col-4">
                        <BarraNavegacion usuario={localStorage.getItem('documento')} />
                    </div>
                    <div className="col-8">
                        <h2>Listado de Edificios y sus Unidades</h2>
                        <button onClick={handleSubmit} className="btn btn-primary">Listar</button>
                        {responseData && (<TablaEdificiosUnidad result={JSON.stringify(responseData, null, 2)} />
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default EdificioConUnidades;
