import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const Card = ({ title, content }) => (
    <div className="card">
        <div className="card-body">
            <h5 className="card-title">{title}</h5>
            <p className="card-text">{content}</p>
        </div>
    </div>
);

const PanelAdministracion = () => (
    <div className="container mt-5">
        <div className="row">
            {/* Tarjetas superiores */}
            <div className="col-md-4">
                <Card title="Tarjeta 1" content="Contenido de la tarjeta 1" />
            </div>
            <div className="col-md-4">
                <Card title="Tarjeta 2" content="Contenido de la tarjeta 2" />
            </div>
            <div className="col-md-4">
                <Card title="Tarjeta 3" content="Contenido de la tarjeta 3" />
            </div>

            {/* Tarjetas inferiores */}
            <div className="col-md-4 mt-4">
                <Card title="Tarjeta 4" content="Contenido de la tarjeta 4" />
            </div>
            <div className="col-md-4 mt-4">
                <Card title="Tarjeta 5" content="Contenido de la tarjeta 5" />
            </div>
            <div className="col-md-4 mt-4">
                <Card title="Tarjeta 6" content="Contenido de la tarjeta 6" />
            </div>
        </div>
    </div>
);

export default PanelAdministracion;
