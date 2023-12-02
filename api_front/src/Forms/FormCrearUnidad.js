import React, { useState } from 'react';

function FormCrearUnidad({ onFormSubmit }) {
    const [pisoUnidad, setPisoUnidad] = useState('');
    const [habitadoUnidad, setHabitadoUnidad] = useState('');
    const [numeroUnidad, setNumeroUnidad] = useState('');
    const [codigoEdificio, setCodigoEdificio] = useState('');

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
            numero: numeroUnidad,
            codigoEdificio: codigoEdificio
        };
        onFormSubmit({ newItem });
    };
    return (

        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="Código del Edificio" className="form-label">Código de Edificio</label>
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

    );
}

export default FormCrearUnidad;