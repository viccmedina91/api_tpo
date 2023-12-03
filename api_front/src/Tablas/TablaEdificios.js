const TablaEdificios = ({ result }) => {

    const respuesta = JSON.parse(result);
    const edificios = Array.isArray(respuesta) ? respuesta : [respuesta];

    console.log(edificios);
    if (!edificios || edificios.length === 0) {
        return <p className="text-muted">No hay unidades para mostrar.</p>;
    }

    return (
        <div className="container mt-3">
            < table className="table table-bordered table-hover" >
                <thead className="thead-dark">
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                    </tr>
                </thead>
                <tbody>
                    {edificios.map((edificio, index) => (
                        <tr key={index}>
                            <td>{edificio.codigo}</td>
                            <td>{edificio.nombre}</td>
                            <td>{edificio.direccion}</td>
                        </tr>
                    ))}
                </tbody>
            </table >
        </div >
    );
};

export default TablaEdificios;
