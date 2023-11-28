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
                        <Subseccion title="Listar los Edificios con sus Unidades" to="/edificio/con/unidades" />
                        <Subseccion title="Listar Inquilinos por Edificio" to="/edificio/inquilinos" />
                        <Subseccion title="Listar habilitados por Edificio" to="/edificio/habilitados" />
                        <Subseccion title="Unidades por Edificio" to="/edificio/unidades" />
                        <Subseccion title="Dueños por Edificio" to="/edificio/duenio/" />
                        <Subseccion title="Crear Edificio" to="/edificio/agregar" />
                        <Subseccion title="Modificar Edificio" to="/edificio/modificar" />
                        <Subseccion title="Eliminar Edificio" to="/edificio/eliminar" />
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
                        <Subseccion title="Crear Unidad" to="/unidad/crear" />
                        <Subseccion title="Modificar Unidad" to="/unidad/modificar" />

                    </Dropdown.Menu>
                </Dropdown>
            </div>
        </div>
    </div >
);

export default PanelAdministracion;
