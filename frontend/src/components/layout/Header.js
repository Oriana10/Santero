import { Link } from 'react-router-dom';
import styles from './Header.module.css';

function Header() {
  return (
    <div className={styles.header}>
      <Link to="/">Logo</Link>
      <div>Navbar</div>
      <div>
        <Link to="/menus">Menus</Link>
        <Link to="/login">Login</Link>
        <Link to="/registro">Registro</Link>
      </div>
    </div>
  );
}

export default Header;
