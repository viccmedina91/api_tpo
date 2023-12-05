import React, { useState } from 'react';
import TablaReclamos from './Tablas/TablaReclamos';
import BarraNavegacion from './BarraNavegacion';

function ListadoReclamo() {
    const [responseData, setResponseData] = useState(null);

    const handleSubmit = () => {
        // Devuelve todos los reclamos cargados en el sistema
        fetch(`http://localhost:8080/reclamo/listar`)
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
                    <div className="col-8"></div>
                    <h2>Listado de Reclamos</h2>
                    <div className="container mt-3">
                        <button type="button" class="btn btn-primary" onClick={handleSubmit}>
                            Listar
                        </button>
                    </div>

                    {responseData && (<TablaReclamos result={JSON.stringify(responseData, null, 2)} />
                    )}
                </div>
            </div>
        </div>
    );
}

export default ListadoReclamo;
