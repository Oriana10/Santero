import { BrowserRouter, Routes, Route } from 'react-router-dom';
// components
import Layout from './components/layout/Layout';
import { Login, Registro, Home, Menus, NotFound, Perfil } from './pages';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="login" element={<Login />} />
          <Route path="registro" element={<Registro />} />
          <Route path="menus" element={<Menus />} />
          <Route path="perfil" element={<Perfil />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
