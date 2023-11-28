import React, { useState } from 'react';

function FormSearch({ onSubmit }) {
    const [campo, setCampo] = useState('');

    const handleCampoChange = (e) => {
        setCampo(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmit(campo);
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Ingrese un valor" className="form-label">Ingresar</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={campo}
                                onChange={handleCampoChange}
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>
                </div>
            </div>
        </div>

    )

}

export default FormSearch;