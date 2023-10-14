import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import SearchEdificio from "./SearchEdificio";
import ListadoEdificio from "./ListadoEdificio";
import ListadoUnidad from "./ListadoUnidad";
import ListadoPersona from "./ListadoPersona";
import ListadoDuenio from "./ListadoDuenio";
import ListadoInquilino from "./ListadoInquilino";
import SearchUnidad from "./SearchUnidad";
import ListadoReclamo from "./ListadoReclamo";
import SearchInquilinoEdificio from "./SearchInquilinoEdificio";
import SearchDuenioEdificio from "./SearchDuenioEdificio";

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
        <Route path="/personas/listar_duenios" element={<ListadoDuenio />}></Route>
        <Route path="/duenio/listar/edifcio" element={<SearchDuenioEdificio />}></Route>

        <Route path="/personas/listar_inquilinos" element={<ListadoInquilino />}></Route>

        <Route path="/inquilino/listar/edificio" element={<SearchInquilinoEdificio />}></Route>

        <Route path="/reclamo/listar" element={<ListadoReclamo />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);