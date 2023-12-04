import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Subseccion from './Subseccion';
import Logout from './Logout';

const PanelUsuario = () => (
    <div className="container mt-5">
        <Logout />
        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/gunidades.jpg'} className="card-img-top" alt="Gestión de Edificio" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Unidades</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar mis unidades</p>
                <ul>
                    <li> <Subseccion title="Mis Unidades" to="/unidad/mis" /></li>
                </ul>
            </div>
        </div>
        <div class="card mb-3">
            <img src={process.env.PUBLIC_URL + '/img/greclamos.jpg'} className="card-img-top" alt="Gestión de Edificio" style={{ height: '200px' }} />
            <div class="card-body">
                <h5 class="card-title">Gestión de Unidades</h5>
                <p class="card-text">En esta sección encontrarás todo lo necesario para administrar mis unidades</p>
                <ul>
                    <li> <Subseccion title="Listar Mis Reclamos" to="/reclamos/mis" /></li>
                    <hr></hr>
                    <li><Subseccion title="Crear Reclamos" to="/reclamos/crear" /></li>
                    <hr></hr>
                    <li><Subseccion title="Agregar Imagen a Reclamos" to="/reclamos/agregar/imagen" /></li>
                    <hr></hr>
                    <li><Subseccion title="Cambiar de estado a Reclamo" to="/reclamos/actualizar/estado" /></li>
                </ul>
            </div>
        </div>
    </div >
);

export default PanelUsuario;
