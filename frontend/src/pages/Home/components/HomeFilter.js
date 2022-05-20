import styles from './HomeFilter.module.css';
import empanadaIcon from '../../../assets/icono-empanada.svg';
import pizzaIcon from '../../../assets/icono-pizza.svg';
import papasIcon from '../../../assets/icono-papas.svg';
import vinagretaIcon from '../../../assets/icono-vinagretas.svg';
import tartaIcon from '../../../assets/icono-tarta.svg';

const foodIcons = [
  {
    name: 'empanadas',
    icon: empanadaIcon,
  },
  {
    name: 'pizzas',
    icon: pizzaIcon,
  },
  {
    name: 'papas',
    icon: papasIcon,
  },
  {
    name: 'vinagretas',
    icon: vinagretaIcon,
  },
  {
    name: 'tartas',
    icon: tartaIcon,
  },
];
function HomeNavbar() {
  const handleChange = (e) => {
    console.log(e.target.value);
  };
  return (
    <ul className={styles.ul}>
      {foodIcons.map(({ name, icon }) => (
        <li className={styles.li} key={name}>
          <label className={styles.label} htmlFor={name}>
            <input
              className={styles.input}
              onChange={handleChange}
              type="radio"
              name="food"
              value={name}
              id={name}
            />
            <img className={styles.img} src={icon} alt={`ícono de ${name}`} />
            <p className={styles.p}>{name}</p>
          </label>
        </li>
      ))}
    </ul>
  );
}

export default HomeNavbar;
