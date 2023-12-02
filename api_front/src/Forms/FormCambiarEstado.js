import React, { useState } from 'react';

function FormCambiarEstado({ onFormSubmit }) {
    const [numero, setNumero] = useState('');
    const [estado, setEstado] = useState('');

    const handleNumeroChange = (e) => {
        setNumero(e.target.value);
    };

    const handleEstadoChange = (e) => {
        setEstado(e.target.value);
    };
    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            numero: numero,
            estado: estado,
        };
        onFormSubmit({ newItem });
    };

    return (
        <div>
            <h2> Actualizar Estado a Reclamo </h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="Nro de Reclamo" className="form-label">Nro de Reclamo</label>
                    <input
                        type="text"
                        className="form-control"
                        id="campoTexto"
                        value={numero}
                        onChange={handleNumeroChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label htmlFor="Estado" className="form-label">Estado</label>
                    <input
                        type="text"
                        className="form-control"
                        id="campoTexto"
                        value={estado}
                        onChange={handleEstadoChange}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary">Enviar</button>
            </form>
        </div>
    )

}

export default FormCambiarEstado;