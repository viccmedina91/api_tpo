function Edificio(result) {
    const edificio = result.result;
    return (
        <div class="card text-bg-success mb-3">
            <div class="card-header">
                Información de Edificio
            </div>
            <div class="card-body">
                <h5 class="card-title">{edificio.nombre}</h5>
                <p class="card-text">Dirección: {edificio.direccion}</p>
                <p class="card-text">Código: {edificio.codigo}</p>
            </div>
        </div>
    );
} export default Edificio;