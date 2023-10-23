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
        <div>
            <h1>Formulario de Búsqueda</h1>
            <input
                type="text"
                value={campo}
                onChange={handleCampoChange}
                placeholder="Código de Edificio"
            />
            <button onClick={handleSubmit}>Buscar</button>
        </div>

    )

}

export default FormSearch;