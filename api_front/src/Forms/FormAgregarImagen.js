import React, { useState } from 'react';
import { FORMATO_IMAGENES } from '../setting/constantes'

function FormAgregarImagen({ onFormSubmit }) {
    const [reclamoid, setReclamoID] = useState('');
    const [path, setPath] = useState('');
    const [tipo, setTipo] = useState('');

    const handleReclamoChange = (e) => {
        setReclamoID(e.target.value);
    };

    const handlePathChange = (e) => {
        setPath(e.target.value);
    };

    const handleTipoChange = (e) => {
        setTipo(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            reclamoid: reclamoid,
            path: path,
            tipo: tipo,
        };
        onFormSubmit({ newItem });
    };

    return (


        <form onSubmit={handleSubmit}>
            <div className="mb-3">
                <label htmlFor="Nro de Reclamo" className="form-label">Nro de Reclamo</label>
                <input
                    type="text"
                    className="form-control"
                    id="campoTexto"
                    value={reclamoid}
                    onChange={handleReclamoChange}
                    required
                />
            </div>
            <div className="mb-3">
                <label>
                    Formato:
                    <select class="form-select form-select-sm" value={tipo} onChange={handleTipoChange}>
                        <option value="">Selecciona un estado</option>
                        {FORMATO_IMAGENES.map((formato) => (
                            <option key={formato.id} value={formato.descripcion}>
                                {formato.descripcion}
                            </option>
                        ))}
                    </select>
                </label>
            </div>
            <div className="mb-3">
                <label htmlFor="Path" className="form-label">Path de Imagen</label>
                <input
                    type="text"
                    className="form-control"
                    id="campoTexto"
                    value={path}
                    onChange={handlePathChange}
                    required
                />
            </div>
            <button type="submit" className="btn btn-primary">Enviar</button>
        </form>

    );
}


export default FormAgregarImagen;