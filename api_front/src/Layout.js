import React, { useState } from 'react';
import { Navigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

const Layout = () => {
    const [documento, setDocumento] = useState('');
    const [contrasenia, setContrasenia] = useState('');
    const [redirectTo, setRedirectTo] = useState(null);
    const [error, setError] = useState(null);

    const authenticate = async () => {
        try {
            console.log(documento);
            console.log(contrasenia)
            // Simular una solicitud al servidor para verificar las credenciales
            const response = await fetch('http://localhost:8080/persona/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ documento, contrasenia }),
            });

            if (response.ok) {
                const data = await response.json();
                console.log(data);
                localStorage.setItem("documento", documento);
                if (data.mensaje === "admin") {
                    setRedirectTo('/admin/panel');
                } else {
                    setRedirectTo('/usuario/panel');
                }
            } else {
                setError('Credenciales inválidas');
            }
        } catch (error) {
            console.error('Error al autenticar:', error);
        }
    };

    if (redirectTo) {
        return <Navigate to={redirectTo} />;
    }

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-body">
                            <h2 className="card-title text-center">Login</h2>

                            <div className="mb-3">
                                <label className="form-label">Documento:</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={documento}
                                    onChange={(e) => setDocumento(e.target.value)}
                                />
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Contraseña:</label>
                                <input
                                    type="password"
                                    className="form-control"
                                    value={contrasenia}
                                    onChange={(e) => setContrasenia(e.target.value)}
                                />
                            </div>

                            <button className="btn btn-primary" onClick={authenticate}>
                                Iniciar Sesión
                            </button>

                            {error && <p className="text-danger mt-3">{error}</p>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Layout;
