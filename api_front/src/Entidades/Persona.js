function Persona(result) {
    const persona = result.result;
    console.log(persona);
    return (
        <div class="card text-bg-success mb-3">
            <div class="card-header">
                Información de Persona Nueva
            </div>
            <div class="card-body">
                <h5 class="card-title">Documento: {persona.documento}</h5>
                <p class="card-text">Nombre: {persona.nombre}</p>
                <p class="card-text">Mail: {persona.mail}</p>
            </div>
        </div>
    );
} export default Persona;