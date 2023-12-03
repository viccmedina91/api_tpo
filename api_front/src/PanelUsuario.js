import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Subseccion from './Subseccion';
import { Dropdown } from 'react-bootstrap';
import Logout from './Logout';

const PanelUsuario = () => (
    <div className="container mt-5">
        <Logout />

        <div className="row">
            {/* Tarjetas superiores */}

            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="warning" id="dropdown-basic">
                        Gestión de Unidades
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Subseccion title="Mis Unidades" to="/unidad/mis" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="danger" id="dropdown-basic">
                        Gestión de Reclamos
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        <Subseccion title="Listar Mis Reclamos" to="/reclamos/mis" />
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
