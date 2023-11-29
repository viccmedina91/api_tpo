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
                        <Subseccion title="Transferir Unidad" to="/unidad/transferir" />
                        <Subseccion title="Agregar Duenio a Unidad" to="/unidad/agregar/duenio/unidad" />
                        <Subseccion title="Agregar Inquilino a Unidad" to="/unidad/agregar/inquilino/unidad" />
                        <Subseccion title="Liberar Unidad" to="/unidad/liberar" />
                        <Subseccion title="Habitar Unidad" to="/unidad/habitar" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>
            <div className="col-md-4">
                <Dropdown>
                    <Dropdown.Toggle variant="danger" id="dropdown-basic">
                        Gestión de Reclamos
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        <Subseccion title="Listar Reclamos por Edificio" to="/reclamos/edificio" />
                        <Subseccion title="Listar Reclamos por Unidad" to="/reclamos/unidad" />
                    </Dropdown.Menu>
                </Dropdown>
            </div>

        </div>
    </div >
);

export default PanelAdministracion;
