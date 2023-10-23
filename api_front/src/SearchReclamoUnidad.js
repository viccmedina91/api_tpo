import React, { useState } from 'react';
import ShowList from "./ShowList";

function App() {
    const [inputValue, setInputValue] = useState('');
    const [responseData, setResponseData] = useState(null);

    const handleInputChange = (e) => {
        setInputValue(e.target.value);
    };

    const handleSubmit = () => {
        // Busca un edificio según el código ingresado
        fetch(`http://localhost:8080/reclamo/unidad/listar/${inputValue}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Manejar la respuesta del backend, esto no se que hace, preguntar
                setResponseData(data);
                console.log(typeof (responseData));
            })
            .catch((error) => {
                console.error('Error al hacer la solicitud:', error);
            });
    };

    return (
        <div>
            <h1>Formulario de Búsqueda</h1>
            <input
                type="text"
                value={inputValue}
                onChange={handleInputChange}
                placeholder="Ingresa un valor"
            />
            <button onClick={handleSubmit}>Buscar</button>

            {responseData && (<ShowList result={JSON.stringify(responseData, null, 2)} />

            )}
        </div>
    );
}

export default App;
