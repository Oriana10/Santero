import styles from './DeliverySteps.module.css';

function DeliverySteps() {
  return (
    <ul className={styles.ul}>
      {[1, 2, 3].map((step) => (
        <>
          <li key={step} className={styles.li}>
            {step}
          </li>
          <span className={styles.line}> </span>
        </>
      ))}
    </ul>
  );
}

export default DeliverySteps;
