import React, { useState } from 'react';

const TablaEdificiosUnidad = ({ result }) => {

    const respuesta = JSON.parse(result);
    const edificios = Array.isArray(respuesta) ? respuesta : [respuesta];
    const [mostrarTabla, setMostrarTabla] = useState(false);

    const toggleTabla = () => {
        setMostrarTabla(!mostrarTabla);
    }
    if (!edificios || edificios.length === 0) {
        return <p className="text-muted">No hay unidades para mostrar.</p>;
    }
    return (
        <div className="container mt-3">
            {edificios.map((edificio, index) => (
                <div key={index}>
                    <ul>
                        <li>Código: {edificio.codigo}</li>
                        <li>Nombre: {edificio.nombre}</li>
                        <li>Dirección: {edificio.direccion}</li>
                    </ul>

                    <button onClick={toggleTabla} className="btn btn-primary">Mostrar Tabla</button>

                    {mostrarTabla && edificio.unidadesSinEdificioViews ? (
                        <table className="table table-bordered table-hover">
                            <thead className="thead-dark">
                                <tr>
                                    <th>Código de Unidad</th>
                                    <th>Piso</th>
                                    <th>Número</th>
                                    <th>Habitado</th>
                                </tr>
                            </thead>
                            <tbody>
                                {edificio.unidadesSinEdificioViews.map((unidad, index) => (
                                    <tr key={index}>
                                        <td>{unidad.id}</td>
                                        <td>{unidad.piso}</td>
                                        <td>{unidad.numero}</td>
                                        <td>{unidad.habitado}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    ) : (
                        <p></p>
                    )}
                </div>
            ))}
        </div>
    );
};


export default TablaEdificiosUnidad;
