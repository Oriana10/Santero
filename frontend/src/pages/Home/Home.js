import SearchInput from '../../components/SearchInput/SearchInput';
import logoPasta from '../../assets/Pasta-cuate.svg';
import styles from './Home.module.css';
import HomeFilter from './components/HomeFilter';
import Card from '../../components/Card/Card';

function Home() {
  return (
    <div>
      <section className={styles.section}>
        <h1 className={styles.h1}>Comidas de tradición desde 1977</h1>
        <SearchInput />
        <div className={styles.foodTitle}>
          <h2 className={styles.h2}>¡No olvides los Domingos de pastas!</h2>
          <img
            className={styles.pastaLogo}
            src={logoPasta}
            alt="mujer comiendo pasta"
          />
        </div>
      </section>
      <HomeFilter />
      <section className={styles.cardList}>
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
      </section>
    </div>
  );
}

export default Home;
