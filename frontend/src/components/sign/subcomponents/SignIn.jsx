import { Formik, Form } from 'formik';
import TextInput from './TextInput'
import styles from '../sign.module.css'

const validateSignIn = (values) => {
  const errors = {}

  if (!values.email) {
    errors.email = '*Requerido'
  }

  if (!values.password) {
    errors.password = '*Requerido'
  } else if (values.password.length < 5) {
    errors.password = '*La contraseña es muy corta'
  }

  return errors
}




const SignIn = (onSubmit) => {
  return (
  <Formik
        initialValues={{ email: '', password: '' }}
        validate={validateSignIn}
        onSubmit={onSubmit}
      >
        <Form className={styles.sign_in_form}>
        <h2 className={styles.title}>Iniciar Sesión</h2>
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

          <input type="submit" value="Iniciar Sesión" className={`${styles.btn} ${styles.solid}`} />
            <p className={styles.social_text}>Or Sign in with social platforms</p>
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

export default SignIn