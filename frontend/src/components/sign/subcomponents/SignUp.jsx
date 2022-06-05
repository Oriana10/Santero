import { Formik, Form } from 'formik';
import TextInput from './TextInput'
import styles from '../sign.module.css'

const validateSignUp = (values) => {
  const errors = {}

  if (!values.name) {
    errors.name = '*Requerido'
  }

  if (!values.lastname) {
    errors.lastname = '*Requerido'
  }

  if (!values.email) {
    errors.email = '*Requerido'
  }

  if (!values.password) {
    errors.password = '*Requerido'
  } else if (values.password.length < 5) {
    errors.password = '*La contraseña es muy corta'
  }

  if (!values.repPassword) {
    errors.repPassword = '*Requerido'
  } else if (values.password !== values.repPassword) {
    errors.repPassword = '*La contraseña no coincide'
  }

  return errors
}

const SignUp = (onSubmit) => {
  return (

    <Formik
      initialValues={{ name: '', lastname: '', email: '', password: ''}}
      validate={validateSignUp}
      onSubmit={onSubmit}
    >
      <Form className={styles.sign_up_form}>
        <h2 className={styles.title}>Registrarse</h2>
        <TextInput
          name='name'
          placeholder='Nombre...'
          i="fas fa-user"
        />
        <TextInput
          name='lastname'
          placeholder='Apellido...'
          i="fas fa-user"
        />
        <TextInput
          name='email'
          placeholder='Correo...'
          type='email'
          i="fas fa-envelope"
        />
        <TextInput
          name='password'
          placeholder='Contraseña...'
          type='password'
          i="fas fa-lock"
        />
        <TextInput
          name='repPassword'
          placeholder='Repetir contraseña...'
          type='password'
          i="fas fa-lock"
        />
        <input type="submit" value="Registrarse" className={`${styles.btn} ${styles.solid}`} />
        <p className={styles.social_text}>Or Sign Up with social platforms</p>
        <div className={styles.social_media}>
          <a href="#" className={styles.social_icon}>
            <i className="fab fa-facebook-f"></i>
          </a>
          <a href="#" className={styles.social_icon}>
            <i className="fab fa-twitter"></i>
          </a>
          <a href="#" className={styles.social_icon}>
            <i className="fab fa-google"></i>
          </a>
          <a href="#" className={styles.social_icon}>
            <i className="fab fa-linkedin-in"></i>
          </a>
        </div>
      </Form>
    </Formik>

  )
}

export default SignUp