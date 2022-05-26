// import Navbar from './Navbar/Navbar';

import styles from './Header.module.css';
import SearchInput from '../SearchInput/SearchInput';
import logoPasta from '../../assets/Pasta-cuate.svg';

function Header() {
  return (
    <div className={styles.header}>
      {/* <Navbar /> */}
      {/** Hero */}
      <section className={styles.section}>
        <div className={styles.maxWidth}>
          <h1 className={styles.h1}>Comidas de tradición desde 1977</h1>
          <SearchInput />
        </div>
        <div className={styles.foodTitle}>
          <div className={`${styles.maxWidth} ${styles.titleFlexRow}`}>
            <h2 className={styles.h2}>¡No olvides los Domingos de pastas!</h2>
            <img
              className={styles.pastaLogo}
              src={logoPasta}
              alt="mujer comiendo pasta"
            />
          </div>
        </div>
      </section>
    </div>
  );
}

export default Header;
