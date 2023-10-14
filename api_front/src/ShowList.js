import React from 'react';

function ShowList({ result }) {
    return (
        <div>
            <h2>Respuesta del Backend:</h2>
            <pre>{result}</pre>
        </div>
    )

}

export default ShowList;