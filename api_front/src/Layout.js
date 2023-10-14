import { Outlet, Link } from "react-router-dom";

const Layout = () => {
    return (
        <>
            <nav>
                <ul>
                    <li>
                        <p>Gestión de Edificios</p>
                        <ul>
                            <li>
                                <Link to="/edificio/buscar">Buscar por Código</Link>
                            </li>
                            <li>
                                <Link to="/edificio/listar">Listar Edificios</Link>
                            </li>
                            <li>
                                <Link to="/edificio/listar_unidades">Listar Unidaddes</Link>
                            </li>
                            <li>
                                <Link to="/edificio/unidades">Unidades por Edificio</Link>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <p>Gestión de Personas</p>
                        <ul>
                            <li>
                                <Link to="/personas/buscar">Buscar Persona por DNI</Link>
                            </li>
                            <li>
                                <Link to="/personas/listar">Listar todas las Personas</Link>
                            </li>
                            <li>
                                <Link to="/personas/listar_duenios">Listar todas los Dueños</Link>
                            </li>
                            <li>
                                <Link to="/duenio/listar/edifcio">Listar todas los Dueños por Edificio</Link>
                            </li>
                            <li>
                                <Link to="/personas/buscar_duenios">Buscar Dueños por DNI</Link>
                            </li>
                            <li>
                                <Link to="/personas/listar_inquilinos">Listar todas los Inquilinos</Link>
                            </li>
                            <li>
                                <Link to="/inquilino/listar/edificio">Listar todas los Inquilinos por Edificio</Link>
                            </li>
                            <li>
                                <Link to="/personas/buscar_inquilinos">Buscar Inquilinos por DNI</Link>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <p>Gestión de Reclamos</p>
                        <ul>
                            <li>
                                <Link to="/reclamos/listar">Listar todos los Reclamos</Link>
                            </li>
                            <li>
                                <Link to="/reclamos/listar/edificio">Listar todos los Reclamos por Edificio</Link>
                            </li>
                            <li>
                                <Link to="/reclamos/listar/unidad">Listar todos los Reclamos por Unidad</Link>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <Outlet />
        </>
    )
};

export default Layout;