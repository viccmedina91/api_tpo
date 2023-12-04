import React, { useState } from 'react';
import Edificio from '../Entidades/Edificio';
import Error from '../Error';
import BarraNavegacion from '../BarraNavegacion';

function CrearEdificio() {
    const [direccionEdificio, setDireccionEdificio] = useState('');
    const [nombreEdificio, setNombreEdificio] = useState('');
    const [responseData, setResponseData] = useState(null);
    const [error, setError] = useState(false);

    const handleDireccionEdificioChange = (e) => {
        setDireccionEdificio(e.target.value);
    };

    const handleNombreEdificioChange = (e) => {
        setNombreEdificio(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            nombre: nombreEdificio,
            direccion: direccionEdificio,
        };
        console.log(newItem);
        fetch('http://localhost:8080/edificio', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newItem),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                console.log('Elemento agregado exitosamente:', data);
                setResponseData(data)
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                };
                setNombreEdificio('');
                setDireccionEdificio('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (

        <div className="container mt-5">
            <div className="row">
                <div className="col-4">
                    <BarraNavegacion />
                </div>
                <div className="col-8">
                    <h2> Formulario para crear un Edificio </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Nombre del Edificio" className="form-label">Nombre</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={nombreEdificio}
                                onChange={handleNombreEdificioChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Dirección del Edificio" className="form-label">Dirección</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={direccionEdificio}
                                onChange={handleDireccionEdificioChange}
                                required
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                    <br></br>

                    {responseData && (
                        <div>
                            {error ? (
                                <Error message={error} />
                            ) : <Edificio result={responseData} />}
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

export default CrearEdificio;
