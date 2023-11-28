import React, { useState } from 'react';
import ShowList from "./ShowList";

function ModificarUnidad() {
    const [pisoUnidad, setPisoUnidad] = useState('');
    const [habitadoUnidad, setHabitadoUnidad] = useState('');
    const [numeroUnidad, setNumeroUnidad] = useState('');
    const [codigoEdificio, setCodigoEdificio] = useState('');
    const [responseData, setResponseData] = useState(null);

    const handleCodigoEdificioChange = (e) => {
        setCodigoEdificio(e.target.value);
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
        fetch(`http://localhost:8080/unidad/${codigoEdificio}`, {
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

                setResponseData(data);
                setCodigoEdificio('');
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
                    <h2> Formulario para crear una Unidad </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Identificador de la Unidad" className="form-label">Identificador Unidad</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={codigoEdificio}
                                onChange={handleCodigoEdificioChange}
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
                </div>
            </div>
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
        </div>
    );
}

export default ModificarUnidad;
