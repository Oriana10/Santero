import { Link } from 'react-router-dom';
import { useAuth0 } from '@auth0/auth0-react';

import styles from './Header.module.css';

import logo from '../../assets/logo-nav.png';
import IconSearch from '../icons/IconSearch';
import IconShopingCart from '../icons/IconShopingCart';
import IconProfile from '../icons/IconProfile';
import LoginButton from '../LoginButton';
import LogoutButton from '../LogoutButton';

function Header() {
  const { isAuthenticated } = useAuth0();

  return (
    <div className={styles.header}>
      <div className={styles.logo}>
        <Link to="/">
          <img src={logo} alt="" />
        </Link>
      </div>

      <ul className={styles.listLinks}>
        <li>
          <Link to="/">Nosotros</Link>
        </li>
        <li>
          <Link to="/">Como Comprar?</Link>
        </li>
        <li>
          <Link to="/menus">Productos</Link>
        </li>
      </ul>

      <div className={styles.menu}>
        <Link to="/buscar">
          <IconSearch />
        </Link>
        <Link to="/carrito">
          <IconShopingCart />
        </Link>
        <Link to="/perfil">
          <IconProfile />
        </Link>
        {isAuthenticated ? <LogoutButton /> : <LoginButton />}
      </div>
    </div>
  );
}

export default Header;
