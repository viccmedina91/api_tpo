import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import Home from "./Home";


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Layout />} />
        <Route path="/home" element={<Home />}>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);