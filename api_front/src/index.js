import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import SearchEdificio from "./SearchEdificio";
import ListadoEdificio from "./ListadoEdificio";
import UnidadesPorEdificio from "./UnidadesPorEdificio";
import SearchUnidad from "./SearchUnidad";
import SearchReclamo from "./SearchReclamo";
import SearchInquilinoEdificio from "./SearchInquilinoEdificio";
import SearchDuenioEdificio from "./SearchDuenioEdificio";
import SearchReclamoEdificio from "./SearchReclamoEdificio";
import SearchReclamoUnidad from "./SearchReclamoUnidad";
import SearchReclamoPersona from "./SearchReclamoPersona";
import ActualizarEstadoReclamo from "./ActualizarEstadoReclamo";
import AddReclamo from "./AddReclamo";
import CrearEdificio from "./Forms/CrearEdificio";
import PanelAdministracion from "./PanelAdministracion";
import EdificioConUnidades from "./EdificioConUnidades";
import ModificarEdificio from "./ModificarEdificio";
import EliminarEdificio from "./EliminarEdificio";
import HabilitadosPorEdificio from "./HabilitadosPorEdificio";
import SearchInquilinoPorUnidad from "./SearchInquilinoPorUnidad";
import CrearUnidad from "./CrearUnidad";
import SearchDuenioPorUnidad from "./SearchDuenioPorUnidad";
import ModificarUnidad from "./ModificarUnidad";
import TransferirUnidad from "./TransferirUnidad";
import AgregarDuenioAUnidad from "./AgregarDuenioAUnidad";
import AgregarInquilinoAUnidad from "./AgregarInquilinoAUnidad";
import LiberarUnidad from "./LiberarUnidad";
import HabitarUnidad from "./HabitarUnidad";
import AddImagen from "./AddImagen";
import ListadoPersona from "./ListadoPersona";
import CrearPersona from "./CrearPersona";
import EliminarPersona from "./EliminarPersona";
import ModificarPersona from "./ModificarPersona";
import PanelUsuario from "./PanelUsuario";
import MisReclamos from "./MisReclamos";
import MisUnidades from "./MisUnidades";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Layout />} />
        <Route path="/edificio/buscar" element={<SearchEdificio />}></Route>
        <Route path="/edificio/listar" element={<ListadoEdificio />}></Route>
        <Route path="/edificio/con/unidades" element={<EdificioConUnidades />}></Route>
        <Route path="/edificio/unidades" element={<UnidadesPorEdificio />}></Route>
        <Route path="/edificio/duenio/" element={<SearchDuenioEdificio />}></Route>
        <Route path="/edificio/agregar" element={<CrearEdificio />}></Route>
        <Route path="/edificio/modificar" element={<ModificarEdificio />}></Route>
        <Route path="/edificio/inquilinos" element={<SearchInquilinoEdificio />}></Route>
        <Route path="/edificio/eliminar" element={<EliminarEdificio />}></Route>
        <Route path="/edificio/habilitados" element={<HabilitadosPorEdificio />}></Route>


        <Route path="/unidad/buscar" element={<SearchUnidad />}></Route>
        <Route path="/unidad/duenios" element={<SearchDuenioPorUnidad />}></Route>
        <Route path="/unidad/inquilinos" element={<SearchInquilinoPorUnidad />}></Route>
        <Route path="/unidad/crear/" element={<CrearUnidad />}></Route>
        <Route path="/unidad/modificar" element={<ModificarUnidad />}></Route>
        <Route path="/unidad/transferir" element={<TransferirUnidad />}></Route>
        <Route path="/unidad/agregar/duenio/unidad" element={<AgregarDuenioAUnidad />}></Route>
        <Route path="/unidad/agregar/inquilino/unidad" element={<AgregarInquilinoAUnidad />}></Route>
        <Route path="/unidad/liberar" element={<LiberarUnidad />}></Route>
        <Route path="/unidad/habitar" element={<HabitarUnidad />}></Route>
        <Route path="/unidad/mis" element={<MisUnidades />}></Route>

        <Route path="/reclamos/edificio" element={<SearchReclamoEdificio />}></Route>
        <Route path="/reclamos/unidad" element={<SearchReclamoUnidad />}></Route>
        <Route path="/reclamos/nro" element={<SearchReclamo />}></Route>
        <Route path="/reclamos/persona" element={<SearchReclamoPersona />}></Route>
        <Route path="/reclamos/crear" element={<AddReclamo />}></Route>
        <Route path="/reclamos/agregar/imagen" element={<AddImagen />}></Route>
        <Route path="/reclamos/actualizar/estado" element={<ActualizarEstadoReclamo />}></Route>
        <Route path="/reclamos/mis" element={<MisReclamos />}></Route>



        <Route path="/persona/listar" element={<ListadoPersona />}></Route>
        <Route path="/persona/crear" element={<CrearPersona />}></Route>
        <Route path="/persona/eliminar" element={<EliminarPersona />}></Route>
        <Route path="/persona/modificar" element={<ModificarPersona />}></Route>








        <Route path="/usuario/panel" element={<PanelUsuario />}></Route>

        <Route path="/admin/panel" element={<PanelAdministracion />}></Route>

      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);