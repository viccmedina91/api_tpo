const TablaPersonas = ({ result }) => {

    const respuesta = JSON.parse(result);
    const personas = Array.isArray(respuesta) ? respuesta : [respuesta];

    console.log(personas);
    if (!personas || personas.length === 0) {
        return <p className="text-muted">No hay personas para mostrar.</p>;
    }

    return (
        <div className="container mt-3">
            < table className="table table-bordered table-hover" >
                <thead className="thead-dark">
                    <tr>
                        <th>Documento</th>
                        <th>Nombre</th>
                        <th>Mail</th>
                    </tr>
                </thead>
                <tbody>
                    {personas.map((persona, index) => (
                        <tr key={index}>
                            <td>{persona.documento}</td>
                            <td>{persona.nombre}</td>
                            <td>{persona.mail}</td>
                        </tr>
                    ))}
                </tbody>
            </table >
        </div >
    );
};

export default TablaPersonas;
