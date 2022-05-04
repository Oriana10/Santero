import iconBag from '../../assets/icon-bag.svg';
import styles from './Card.module.css';

function Card() {
  return (
    <article className={styles.article}>
      <div>
        <img
          className={styles.cardImg}
          src="https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
          alt="comida"
        />
      </div>
      <h3>Pizza</h3>
      <div className={styles.cardPriceInfo}>
        <p>10$</p>
        <button
          className={styles.cardBtn}
          type="button"
          aria-label="agregar a la bolsa"
        >
          <img
            className={styles.bagLogo}
            src={iconBag}
            alt="bolsa de compras"
          />
        </button>
      </div>
    </article>
  );
}

export default Card;
