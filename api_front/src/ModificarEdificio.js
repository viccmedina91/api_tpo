import React, { useState } from 'react';
import ShowList from './ShowList';

function ModificarEdificio() {
    const [direccionEdificio, setDireccionEdificio] = useState('');
    const [nombreEdificio, setNombreEdificio] = useState('');
    const [codigoEdificio, setCodigoEdificio] = useState('');
    const [responseData, setResponseData] = useState(null);

    const handleCodigoEdificioChange = (e) => {
        setCodigoEdificio(e.target.value);
    };
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
        fetch(`http://localhost:8080/edificio/${codigoEdificio}`, {
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
                setCodigoEdificio('')
                setNombreEdificio('');
                setDireccionEdificio('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
            });
    };

    return (

        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <h2> Formulario para modificar un Edificio </h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Código del Edificio" className="form-label">Código</label>
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
                </div>
            </div>
            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />
            )}
        </div>
    );
}

export default ModificarEdificio;
