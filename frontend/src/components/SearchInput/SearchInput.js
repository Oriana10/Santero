import { useState } from 'react';
import styles from './SearchInput.module.css';

function SearchInput() {
  const [food, setFood] = useState('');
  const handleChange = (e) => {
    setFood(e.target.value);
  };
  return (
    <form className={styles.form}>
      <div className={styles.inputContact}>
        <p># de contacto</p>
        <p>Estamos ubicados en:</p>
      </div>
      <input
        className={styles.input}
        onChange={handleChange}
        type="text"
        value={food}
        placeholder="¿Qué quieres pedir hoy?"
      />
    </form>
  );
}

export default SearchInput;
