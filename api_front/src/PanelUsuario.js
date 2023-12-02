import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Subseccion from './Subseccion';
import { Dropdown } from 'react-bootstrap';

const PanelUsuario = () => (
    <div className="container mt-5">
        <div className="row">
            {/* Tarjetas superiores */}
            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        Gestión de Edificios
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Subseccion title="Listar Edificios" to="/edificio/listar" />
                        <Subseccion title="Buscar Edificio por código" to="/edificio/buscar" />
                        <Subseccion title="Listar Inquilinos por Edificio" to="/edificio/inquilinos" />
                        <Subseccion title="Unidades por Edificio" to="/edificio/unidades" />
                        <Subseccion title="Dueños por Edificio" to="/edificio/duenio/" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="warning" id="dropdown-basic">
                        Gestión de Unidades
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Subseccion title="Buscar Unidad" to="/unidad/buscar" />
                        <Subseccion title="Buscar Dueños por Unidad" to="/unidad/duenios" />
                        <Subseccion title="Buscar Inquilinos por Unidad" to="/unidad/inquilinos" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="danger" id="dropdown-basic">
                        Gestión de Reclamos
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        <Subseccion title="Buscar Reclamos por Nro." to="/reclamos/nro" />
                        <Subseccion title="Buscar Reclamos por Documento" to="/reclamos/persona" />
                        <Subseccion title="Crear Reclamos" to="/reclamos/crear" />
                        <Subseccion title="Agregar Imagen a Reclamos" to="/reclamos/agregar/imagen" />
                        <Subseccion title="Cambiar de estado a Reclamo" to="/reclamos/actualizar/estado" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>
        </div>
        <div className="container mt-5">
            <div className="row">

                <div className="col-md-4">
                    <Dropdown>
                        <Dropdown.Toggle variant="info" id="dropdown-basic">
                            Gestión de Personas
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Subseccion title="Listar todas las Personas" to="/persona/listar" />
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </div>
        </div>
    </div >
);

export default PanelUsuario;