import React, { useState } from 'react';
import { ESTADOS_RECLAMO, ESTADOS_RECLAMO_USUARIO } from '../setting/constantes';

function FormCambiarEstado({ onFormSubmit }) {
    const [numero, setNumero] = useState('');
    const [estado, setEstado] = useState('');

    let listado_estado = ESTADOS_RECLAMO;
    if (localStorage.getItem('documento') !== '1234') {
        listado_estado = ESTADOS_RECLAMO_USUARIO;
    }
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
            documento: localStorage.getItem('documento'),
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
                            {listado_estado.map((estado) => (
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