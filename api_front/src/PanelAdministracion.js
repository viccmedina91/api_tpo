import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Subseccion from './Subseccion';
import Logout from './Logout';

const PanelAdministracion = () => (

    <div className="container mt-5">
        <nav class="navbar fixed-top bg-body-tertiary">
            <div class="container-fluid">
                <Logout />
            </div>
        </nav>

        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/gedificio.jpg'} className="card-img-top" alt="Gestión de Edificio" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Edificios</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar los Edificios</p>
                <ul>
                    <li> <Subseccion title="Listar Edificios" to="/edificio/listar" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Buscar Edificio por código" to="/edificio/buscar" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Listar los Edificios con sus Unidades" to="/edificio/con/unidades" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Listar Inquilinos por Edificio" to="/edificio/inquilinos" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Listar habilitados por Edificio" to="/edificio/habilitados" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Unidades por Edificio" to="/edificio/unidades" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Dueños por Edificio" to="/edificio/duenio/" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Crear Edificio" to="/edificio/agregar" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Modificar Edificio" to="/edificio/modificar" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Eliminar Edificio" to="/edificio/eliminar" /></li>
                </ul>
            </div>
        </div>

        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/gunidades.jpg'} className="card-img-top" alt="Gestión de Unidades" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Unidades</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar las Unidades</p>
                <ul>
                    <li> <Subseccion title="Buscar Unidad" to="/unidad/buscar" /></li>
                    <hr></hr>
                    <li>   <Subseccion title="Buscar Dueños por Unidad" to="/unidad/duenios" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Buscar Inquilinos por Unidad" to="/unidad/inquilinos" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Crear Unidad" to="/unidad/crear" /></li>
                    <hr></hr>
                    <li>   <Subseccion title="Modificar Unidad" to="/unidad/modificar" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Transferir Unidad" to="/unidad/transferir" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Agregar Duenio a Unidad" to="/unidad/agregar/duenio/unidad" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Agregar Inquilino a Unidad" to="/unidad/agregar/inquilino/unidad" /></li>
                    <hr></hr>
                    <li>  <Subseccion title="Liberar Unidad" to="/unidad/liberar" /></li>
                    <hr></hr>
                    <li> <Subseccion title="Habitar Unidad" to="/unidad/habitar" /></li>
                </ul>
            </div>
        </div>

        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/greclamos.jpg'} className="card-img-top" alt="Gestión de Reclamos" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Reclamos</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar los Reclamos</p>
                <ul>
                    <li><Subseccion title="Listar Reclamos por Edificio" to="/reclamos/edificio" /></li>
                    <hr></hr>
                    <li><Subseccion title="Listar Reclamos por Unidad" to="/reclamos/unidad" /></li>
                    <hr></hr>
                    <li><Subseccion title="Buscar Reclamos por Nro." to="/reclamos/nro" /></li>
                    <hr></hr>
                    <li><Subseccion title="Buscar Reclamos por Documento" to="/reclamos/persona" /></li>
                    <hr></hr>
                    <li><Subseccion title="Crear Reclamo" to="/reclamos/crear" /></li>
                    <hr></hr>
                    <li><Subseccion title="Agregar Imagen a Reclamo" to="/reclamos/agregar/imagen" /></li>
                    <hr></hr>
                    <li><Subseccion title="Cambiar de estado a Reclamo" to="/reclamos/actualizar/estado" /></li>
                    <hr></hr>
                </ul>
            </div>
        </div>

        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/gpersona.jpg'} className="card-img-top" alt="Gestión de Personas" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Personas</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar los Inquilinos Y Dueños</p>
                <ul>
                    <li><Subseccion title="Listar todas las Personas" to="/persona/listar" /></li>
                    <hr></hr>
                    <li><Subseccion title="Crear Persona" to="/persona/crear" /></li>
                    <hr></hr>
                    <li><Subseccion title="Eliminar Persona" to="/persona/eliminar" /></li>
                    <hr></hr>
                    <li><Subseccion title="Modificar Persona" to="/persona/modificar" /></li>
                </ul>
            </div>
        </div>
    </div >
);

export default PanelAdministracion;
