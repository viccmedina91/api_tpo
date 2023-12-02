import React, { useState } from 'react';
import { Navigate } from 'react-router-dom';

const Logout = () => {
    const [redirectTo, setRedirectTo] = useState(null);
    const handleLogout = () => {
        // Elimina el valor del documento del localStorage
        localStorage.removeItem('documento');

        // Redirige al usuario a la página de inicio de sesión
        setRedirectTo('/');
    };
    if (redirectTo) {
        return <Navigate to={redirectTo} />;
    }
    return (
        <button type="button" class="btn btn-primary" onClick={handleLogout}>
            Cerrar Sesión
        </button>
    );
};

export default Logout;
