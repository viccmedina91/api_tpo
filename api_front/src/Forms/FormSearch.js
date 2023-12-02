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
    )

}

export default FormSearch;