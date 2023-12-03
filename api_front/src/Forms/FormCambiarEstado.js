import React, { useState } from 'react';
import { ESTADOS_RECLAMO } from '../setting/constantes';

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
                    <label>
                        Estado del reclamo:
                        <select class="form-select form-select-sm" value={estado} onChange={handleEstadoChange}>
                            <option value="">Selecciona un estado</option>
                            {ESTADOS_RECLAMO.map((estado) => (
                                <option key={estado.id} value={estado.id}>
                                    {estado.descripcion}
                                </option>
                            ))}
                        </select>
                    </label>
                </div>
                <button type="submit" className="btn btn-primary">Enviar</button>
            </form>
        </div>
    )

}

export default FormCambiarEstado;