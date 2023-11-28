import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Subseccion from './Subseccion';
import { Dropdown } from 'react-bootstrap';

const PanelAdministracion = () => (
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
                        <Subseccion title="Listas los Edificios con sus Unidades" to="/edificio/con/unidades" />

                        {/* Agrega más subsecciones según sea necesario */}
                    </Dropdown.Menu>
                </Dropdown>
            </div>
        </div>
    </div>
);

export default PanelAdministracion;
