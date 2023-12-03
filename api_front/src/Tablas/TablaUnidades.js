const TablaUnidades = ({ result }) => {
    const unidades = JSON.parse(result);

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

                    </tr>
                </thead>
                <tbody>
                    {unidades.map((unidad, index) => (
                        <tr key={index}>
                            <td>{unidad.edificio.nombre}</td>
                            <td>{unidad.identificador}</td>
                            <td>{unidad.numero}</td>
                            <td>{unidad.piso}</td>
                        </tr>
                    ))}
                </tbody>
            </table >
        </div >
    );
};

export default TablaUnidades;
