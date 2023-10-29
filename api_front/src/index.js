import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import SearchEdificio from "./SearchEdificio";
import ListadoEdificio from "./ListadoEdificio";
import ListadoUnidad from "./ListadoUnidad";
import ListadoPersona from "./ListadoPersona";
import SearchPersona from "./SearchPersona";
import ListadoDuenio from "./ListadoDuenio";
import SearchDuenio from "./SearchDuenio";
import ListadoInquilino from "./ListadoInquilino";
import SearchInquilino from "./SearchInquilino";
import SearchUnidad from "./SearchUnidad";
import ListadoReclamo from "./ListadoReclamo";
import SearchReclamo from "./SearchReclamo";
import SearchInquilinoEdificio from "./SearchInquilinoEdificio";
import SearchDuenioEdificio from "./SearchDuenioEdificio";
import SearchReclamoEdificio from "./SearchReclamoEdificio";
import SearchReclamoUnidad from "./SearchReclamoUnidad";
import SearchReclamoPersona from "./SearchReclamoPersona";
import AddReclamo from "./AddReclamo";
import AddDuenio from "./AddDuenio";
import AddInquilino from "./AddInquilino";
import ListadoEstado from "./ListadoEstado";
import AddImagen from "./AddImagen";
import SearchImagenReclamo from "./SearchImagenReclamo";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Layout />} />
        <Route path="/edificio/buscar" element={<SearchEdificio />}></Route>
        <Route path="/edificio/listar" element={<ListadoEdificio />}></Route>
        <Route path="/edificio/listar_unidades" element={<ListadoUnidad />}></Route>
        <Route path="/edificio/unidades" element={<SearchUnidad />}></Route>

        <Route path="/personas/listar" element={<ListadoPersona />}></Route>
        <Route path="/personas/buscar" element={<SearchPersona />}></Route>
        <Route path="/duenio/buscar" element={<SearchDuenio />}></Route>
        <Route path="/personas/listar_duenios" element={<ListadoDuenio />}></Route>
        <Route path="/duenio/listar/edifcio" element={<SearchDuenioEdificio />}></Route>
        <Route path="/duenio/agregar" element={<AddDuenio />}></Route>

        <Route path="/personas/listar_inquilinos" element={<ListadoInquilino />}></Route>
        <Route path="/inquilino/listar/edificio" element={<SearchInquilinoEdificio />}></Route>
        <Route path="/inquilino/agregar" element={<AddInquilino />}></Route>
        <Route path="/inquilino/buscar" element={<SearchInquilino />}></Route>

        <Route path="/reclamos/listar" element={<ListadoReclamo />}></Route>
        <Route path="/reclamos/listar/edificio" element={<SearchReclamoEdificio />}></Route>
        <Route path="/reclamos/listar/unidad" element={<SearchReclamoUnidad />}></Route>
        <Route path="/reclamos/listar/persona" element={<SearchReclamoPersona />}></Route>
        <Route path="/reclamos/agregar" element={<AddReclamo />}></Route>
        <Route path="/imagenes/agregar" element={<AddImagen />}></Route>
        <Route path="/reclamos/listar/nro" element={<SearchReclamo />}></Route>
        <Route path="/imagenes/segun/reclamo" element={<SearchImagenReclamo />}></Route>


        <Route path="/estados/listar/" element={<ListadoEstado />}></Route>

      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);