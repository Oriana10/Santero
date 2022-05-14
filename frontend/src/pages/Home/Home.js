import styles from './Home.module.css';
import HomeFilter from './components/HomeFilter';
import Card from '../../components/Card/Card';

function Home() {
  return (
    <div>
      <HomeFilter />
      <section className={styles.cardList}>
        {/* Ejemplo */}
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
