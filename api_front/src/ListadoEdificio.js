import React, { useEffect, useState } from 'react';

function ListaEdificios() {
    const [edificios, setEdificios] = useState([]);

    useEffect(() => {
        // Aquí haremos la solicitud al backend para obtener la lista de edificios
        fetch('http://localhost:8080/edificio/getAllEdificios')
            .then((response) => response.json())
            .then((data) => {
                setEdificios(data)
                console.log(data)
            });
    }, []);

    return (
        <div>
            <h1>Lista de Edificios</h1>
            {console.log(edificios)}
            <ul>
                {edificios.map((edificio) => (
                    <li key={edificio.id}>{edificio.nombre} - {edificio.direccion}</li>
                ))}
            </ul>
        </div>
    );
}

export default ListaEdificios;
