const TablaUnidades = ({ result }) => {
    const respuesta = JSON.parse(result);
    const unidades = Array.isArray(respuesta) ? respuesta : [respuesta];
    console.log(unidades);
    if (!unidades || unidades.length === 0) {
        return <p className="text-muted">No hay unidades para mostrar.</p>;
    }

    return (
        <div className="container mt-3">
            < table className="table table-bordered table-hover" >
                <thead className="thead-dark">
                    <tr>
                        <th>Edificio</th>
                        <th>Código Unidad</th>
                        <th>Número</th>
                        <th>Piso</th>
                        <th>Habitado</th>
                    </tr>
                </thead>
                <tbody>
                    {unidades.map((unidad, index) => (
                        <tr key={index}>
                            <td>{unidad.edificio.nombre}</td>
                            <td>{unidad.identificador}</td>
                            <td>{unidad.numero}</td>
                            <td>{unidad.piso}</td>
                            <td>{unidad.habitado}</td>
                        </tr>
                    ))}
                </tbody>
            </table >
        </div >
    );
};

export default TablaUnidades;
