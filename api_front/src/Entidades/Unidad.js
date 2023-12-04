function Unidad(result) {
    const unidad = result.result;
    return (
        <div class="card text-bg-success mb-3">
            <div class="card-header">
                Información de la Unidad
            </div>
            <div class="card-body">
                <h5 class="card-title">Código: {unidad.identificador}</h5>
                <p class="card-text">Edificio: {unidad.edificio.nombre}</p>
                <p class="card-text">Numero: {unidad.numero}</p>
                <p class="card-text">Piso: {unidad.piso}</p>
                <p class="card-text">Habitada: {unidad.habitado}</p>
            </div>
        </div>
    );
}

export default Unidad;