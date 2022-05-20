import DeliverySteps from '../DeliverySteps/DeliverySteps';
import styles from './Entrega.module.css';
import logoPedido from '../../assets/entrega-pedido.png';

function Entrega() {
  return (
    <article className={styles.entrega}>
      <DeliverySteps />

      <p className={styles.title}>Tu delivery está a la puerta</p>
      <div className={styles.details}>
        <p>Pizza Peperoni</p>
        <p>Total: 50</p>
        <p>código:a5224AB1353</p>
      </div>
      <img
        className={styles.img}
        src={logoPedido}
        alt="repartidor entregando el pedido"
      />
      <button className={styles.button} type="button">
        Gracias por confiar en nosotros
      </button>
    </article>
  );
}

export default Entrega;
