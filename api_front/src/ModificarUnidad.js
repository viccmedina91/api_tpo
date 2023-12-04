import React, { useState } from 'react';
import ShowList from "./ShowList";
import Error from './Error';

function ModificarUnidad() {
    const [pisoUnidad, setPisoUnidad] = useState('');
    const [error, setError] = useState(false);
    const [habitadoUnidad, setHabitadoUnidad] = useState('');
    const [numeroUnidad, setNumeroUnidad] = useState('');
    const [codigoUnidad, setCodigoUnidad] = useState('');
    const [responseData, setResponseData] = useState(null);

    const handleCodigoUnidadChange = (e) => {
        setCodigoUnidad(e.target.value);
    };
    const handlePisoUnidadChange = (e) => {
        setPisoUnidad(e.target.value);
    };

    const handleHabitadoUnidadChange = (e) => {
        setHabitadoUnidad(e.target.value);
    };

    const handleNumeroChange = (e) => {
        setNumeroUnidad(e.target.value);
    };


    const handleSubmit = (e) => {
        e.preventDefault();
        // Crear un objeto con los datos del formulario
        const newItem = {
            piso: pisoUnidad,
            habitado: habitadoUnidad,
            numero: numeroUnidad
        };
        console.log(newItem);
        fetch(`http://localhost:8080/unidad/${codigoUnidad}`, {
            method: 'PUT',
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
                // Restablecer los campos del formulario
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
                setResponseData(data);
                setCodigoUnidad('');
                setPisoUnidad('');
                setNumeroUnidad('');
                setHabitadoUnidad('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (

        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <h2> Formulario para modificar  una Unidad </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Identificador de la Unidad" className="form-label">Identificador Unidad</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={codigoUnidad}
                                onChange={handleCodigoUnidadChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Piso" className="form-label">Piso</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={pisoUnidad}
                                onChange={handlePisoUnidadChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Habitado" className="form-label">Habitado</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={habitadoUnidad}
                                onChange={handleHabitadoUnidadChange}
                                required
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="Numero" className="form-label">Número</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={numeroUnidad}
                                onChange={handleNumeroChange}
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
                            ) : <ShowList result={JSON.stringify(responseData.mensaje, null, 2)} />}
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}

export default ModificarUnidad;
