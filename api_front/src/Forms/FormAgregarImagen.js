import React, { useState } from 'react';

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

        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
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
                            <label htmlFor="Tipo" className="form-label">Tipo</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={tipo}
                                onChange={handleTipoChange}
                                required
                            />
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
                </div>
            </div>
        </div>
    );
}


export default FormAgregarImagen;