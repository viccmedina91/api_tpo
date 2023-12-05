import React, { useState } from 'react';
import ShowList from "./ShowList";
import { ESPACIOS_COMUNES } from './setting/constantes';
import Error from './Error';
import BarraNavegacion from './BarraNavegacion';

function AddReclamo() {
    const [ubicacion, setUbicacion] = useState('');
    const [descripcion, setDescripcion] = useState('');
    const [documento, setDocumento] = useState('');
    const [codigo, setCodigo] = useState('');
    const [identificador, setIdentificador] = useState('');
    const [error, setError] = useState(null);
    const [responseData, setResponseData] = useState(null);
    const [esAreaComun, setEsAreaComun] = useState(false);

    const handleUbicacionChange = (e) => {
        setUbicacion(e.target.value);
    };

    const handleDescripcionChange = (e) => {
        setDescripcion(e.target.value);
    };

    const handleDocumentoChange = (e) => {
        setDocumento(e.target.value);
    };

    const handleCodigoChange = (e) => {
        setCodigo(e.target.value);
    };

    const handleIdentificadorChange = (e) => {
        setIdentificador(e.target.value);
    };

    const handleChangeTipoReclamo = (e) => {
        setEsAreaComun(e.target.value === 'areaComun');
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Crear un objeto con los datos del formulario
        const newItem = {
            ubicacion: ubicacion,
            descripcion: descripcion,
            documento: documento,
            areaComun: esAreaComun
        };
        if (esAreaComun) {
            newItem.codigo = codigo;
            newItem.identidicador = null;
        } else {
            newItem.codigo = null;
            newItem.identificador = identificador;
        }
        console.log(newItem);
        fetch('http://localhost:8080/reclamo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newItem),
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                // Realizar acciones adicionales después de la inserción exitosa
                console.log('Elemento agregado exitosamente:', data);
                // Restablecer los campos del formulario
                setResponseData(data);
                if (data.mensaje.toLowerCase().includes('error')) {
                    setError(data.mensaje);
                }
                setDescripcion('');
                setUbicacion('');
                setDocumento('');
                setCodigo('');
                setIdentificador('');

            })
            .catch((error) => {
                console.error('Error al agregar el elemento:', error);
                setError(error.mensaje);
            });
    };

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-4">
                    <BarraNavegacion usuario={localStorage.getItem('documento')} />
                </div>
                <div className="col-8">
                    <h2> Formulario para agregar un Reclamo</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="mb-3">
                            <label htmlFor="Documento" className="form-label">Documento</label>
                            <input
                                type="text"
                                className="form-control"
                                id="campoTexto"
                                value={documento}
                                onChange={handleDocumentoChange}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Tipo de reclamo:</label>
                            <div className="form-check">
                                <input
                                    type="radio"
                                    id="areaComun"
                                    name="tipoReclamo"
                                    value="areaComun"
                                    checked={esAreaComun}
                                    onChange={handleChangeTipoReclamo}
                                    className="form-check-input"
                                />
                                <label htmlFor="areaComun" className="form-check-label">Área común</label>
                            </div>
                            <div className="form-check">
                                <input
                                    type="radio"
                                    id="noAreaComun"
                                    name="tipoReclamo"
                                    value="noAreaComun"
                                    checked={!esAreaComun}
                                    onChange={handleChangeTipoReclamo}
                                    className="form-check-input"
                                />
                                <label htmlFor="noAreaComun" className="form-check-label">No es área común</label>
                            </div>
                        </div>
                        {esAreaComun ? (
                            <div className="form-group">
                                <label htmlFor="codigoEdificio">Código de Edificio:</label>
                                <input
                                    type="text"
                                    id="codigo"
                                    className="form-control"
                                    value={codigo}
                                    onChange={handleCodigoChange}
                                />

                                <label>
                                    Área Común:
                                    <select class="form-select form-select-sm" value={ubicacion} onChange={handleUbicacionChange}>
                                        <option value="ubicacion">Área afectada</option>
                                        {ESPACIOS_COMUNES.map((espacio) => (
                                            <option key={espacio.id} value={espacio.descripcion}>
                                                {espacio.descripcion}
                                            </option>
                                        ))}
                                    </select>
                                </label>
                                <div className="mb-3">
                                    <label htmlFor="Descripción" className="form-label">Descripción</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="campoTexto"
                                        value={descripcion}
                                        onChange={handleDescripcionChange}
                                        required
                                    />
                                </div>
                            </div>

                        ) : (
                            <div>
                                <div className="form-group">
                                    <label htmlFor="codigoUnidad">Código de Unidad:</label>
                                    <input
                                        type="text"
                                        id="iedntificador"
                                        className="form-control"
                                        value={identificador}
                                        onChange={handleIdentificadorChange}
                                    />
                                </div>

                                <div className="mb-3">
                                    <label htmlFor="Descripción" className="form-label">Descripción</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="campoTexto"
                                        value={descripcion}
                                        onChange={handleDescripcionChange}
                                        required
                                    />
                                </div>
                            </div>
                        )}
                        <button type="submit" className="btn btn-primary">Enviar</button>
                    </form>

                    <br></br>
                    {responseData && (
                        <div>
                            {error ? (
                                <Error message={error} />
                            ) : <ShowList result={JSON.stringify(responseData.mensaje, null, 2)} />}
                        </div>
                    )}
                </div>
            </div>

        </div>
    );
}

export default AddReclamo;
