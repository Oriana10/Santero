import styles from './Footer.module.css'
import Logo from './img/logo.png'

const Footer = () => {
  return (
    <footer className={styles.footer}>
      <div className={styles.imgContainer}>
        <img src={Logo} alt="" className={styles.img}/>
      </div>
      <div className={styles.textContainer}>
        <div className={styles.leftText}>
        <p className={styles.text}>¿Cómo comprar?</p>
        <p className={styles.text}>Av.Ovidio Lagos 1495,s2000QLH Rosario, Santa Fe</p>
        </div>
        <div className={styles.rightText}>
        <p className={styles.text}>Menú</p>
        <p className={styles.text}> Contacto: 0341-6551909</p>
        </div>
      </div>
    </footer>
  )
}

export default Footer;