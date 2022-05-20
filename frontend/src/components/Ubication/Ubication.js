import styles from './Ubication.module.css';

function Ubication() {
  return (
    <div className={styles.ubication}>
      {/* Aqui toca reutilizar el header para regresar <- */}
      <p>Calle marroquí 123456</p>

      <iframe
        src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d92523.01816184279!2d-100.28036441578892!3d25.79281223574396!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses-419!2smx!4v1652470333333!5m2!1ses-419!2smx"
        width="250"
        height="250"
        style={{ border: 0 }}
        allowFullScreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
        title="ubication"
      />
      <button className={styles.button} type="button">
        Agregar ubicación
      </button>
    </div>
  );
}

export default Ubication;
