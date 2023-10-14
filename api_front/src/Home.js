import React, { useState } from 'react';

const Home = () => {
    const [edificios, setEdificios] = useState([]);

    const handleGetEdificios = async () => {
        try {
            const response = await fetch('http://localhost:8080/edificio/getAllEdificios');
            if (response.ok) {
                const data = await response.json();
                setEdificios(data);
            } else {
                // Manejar errores si es necesario
            }
        } catch (error) {
            // Manejar errores de conexión, etc.
        }
    };

    return (
        <div>
            <h1>Lista de Edificios</h1>
            <button onClick={handleGetEdificios}>Todos los Edificios</button>
            <ul>
                {edificios.map((edificio) => (
                    <li key={edificio.codigo}>{edificio.nombre}</li>
                ))}
            </ul>
        </div>
    );
};

export default Home;