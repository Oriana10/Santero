import logo from '../../assets/logo-nav.png';
import styles from './Footer.module.css';

function Footer() {
  return (
    <footer className={styles.footer}>
      <ul className={styles.linksFooter}>
        <li>Como comprar?</li>
        <li>Medios de Pago</li>
        <li>Nosotros</li>
      </ul>

      <div className={styles.logoFooter}>
        <img src={logo} alt=" " />
      </div>

      <div className={styles.redesFooter}>
        <div>Copyright</div>
        <div>Redes</div>
      </div>
    </footer>
  );
}

export default Footer;
