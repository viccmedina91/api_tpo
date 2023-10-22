import React, { useState } from 'react';

function FormNewDuenioInquilino({ onSubmit }) {
    const [identificador, setIdentificador] = useState('');
    const [nombre, setNombre] = useState('');
    const [documento, setDocumento] = useState('');
    const [mail, setMail] = useState('');
    const [contrasenia, setContrasenia] = useState('');

    const handleIdentificadorChange = (e) => {
        setIdentificador(e.target.value);
    };

    const handleNombreChange = (e) => {
        setNombre(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };

    const handleMailChange = (e) => {
        setMail(e.target.value);
    };

    const handleContraseniaChange = (e) => {
        setContrasenia(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            identificador: identificador,
            nombre: nombre,
            documento: documento,
            contrasenia: contrasenia,
            mail: mail,
        };
        onSubmit(newItem);
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="Nombre">Nombre:</label>
                <input
                    type="text"
                    id="nombre"
                    value={nombre}
                    onChange={handleNombreChange}
                />
            </div>
            <div>
                <label htmlFor="documento">Documento:</label>
                <input
                    type="text"
                    id="documento"
                    value={documento}
                    onChange={handleDocumentoChange}
                />
            </div>
            <div>
                <label htmlFor="mail">Mail:</label>
                <input
                    type="text"
                    id="mail"
                    value={mail}
                    onChange={handleMailChange}
                />
            </div>
            <div>
                <label htmlFor="contrasenia">Contraseña:</label>
                <input
                    type="text"
                    id="contrasenia"
                    value={contrasenia}
                    onChange={handleContraseniaChange}
                />
            </div>
            <div>
                <label htmlFor="identidicador">Número de Unidad:</label>
                <input
                    type="text"
                    id="identificador"
                    value={identificador}
                    onChange={handleIdentificadorChange}
                />
            </div>
            <button type="submit">Agregar</button>
        </form>
    )

}

export default FormNewDuenioInquilino;