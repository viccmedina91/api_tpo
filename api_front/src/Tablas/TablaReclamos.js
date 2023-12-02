import React, { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const TablaReclamos = ({ result }) => {
    const [mostrarModal, setMostrarModal] = useState(false);
    const [imagenSeleccionada, setImagenSeleccionada] = useState('');
    console.log("Tabla Reclamos");
    console.log(result);
    const reclamos = JSON.parse(result);
    console.log(reclamos);



    const abrirModal = (imagen) => {
        setImagenSeleccionada(imagen);
        setMostrarModal(true);
    };

    const cerrarModal = () => {
        setMostrarModal(false);
    };

    if (!reclamos || reclamos.length === 0) {
        return <p className="text-muted">No hay reclamos para mostrar.</p>;
    }

    return (
        <div className="container mt-3">
            <Modal show={mostrarModal} onHide={cerrarModal} centered>
                <Modal.Header closeButton>
                    <Modal.Title>Imagen del reclamo</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <img src={imagenSeleccionada.direccion} alt="Imagen del reclamo" className="img-fluid" />
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={cerrarModal}>
                        Cerrar
                    </Button>
                </Modal.Footer>
            </Modal>
            < table className="table table-bordered table-hover" >
                <thead className="thead-dark">
                    <tr>
                        <th>Número</th>
                        <th>Edificio</th>
                        <th>Código Unidad</th>
                        <th>Descripción</th>
                        <th>Estado</th>
                        <th>Imágenes</th>
                    </tr>
                </thead>
                <tbody>
                    {reclamos.map((reclamo, index) => (
                        <tr key={index}>
                            <td>{reclamo.numero}</td>
                            <td>{reclamo.edificio.nombre}</td>
                            <td>{reclamo.unidad.identificador}</td>
                            <td>{reclamo.descripcion}</td>
                            <td>{reclamo.estado.descripcion}</td>
                            <td>
                                {reclamo.imagenes && reclamo.imagenes.length > 0 ? (
                                    // Si hay imágenes, muestra enlaces a todas ellas
                                    <ul>
                                        {reclamo.imagenes.map((imagen, i) => (
                                            <li>
                                                <button className="btn btn-link" onClick={() => abrirModal(imagen)}>
                                                    Ver imagen
                                                </button>
                                            </li>

                                        ))}
                                    </ul>
                                ) : (
                                    // Si no hay imágenes, muestra el texto correspondiente
                                    <span>No hay imágenes cargadas</span>
                                )}
                                <br></br>
                                <Link to={'/reclamos/agregar/imagen'}>
                                    Cargar Imagen
                                </Link>
                            </td>

                        </tr>
                    ))}
                </tbody>
            </table >
        </div >
    );
};

export default TablaReclamos;
