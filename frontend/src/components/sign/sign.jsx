import { useState } from 'react';
import styles from './sign.module.css';
import Logo from './img/signin2.svg';
import Register from './img/signup2.svg';

import { httpPost } from '../../utils/HttpFunctions';
import SignUp from './subcomponents/SignUp';
import SignIn from './subcomponents/SignIn';

const Sign = () => {
  const [sign, setSign] = useState(false);

  const SwitchSign = () => { sign ? setSign(false) : setSign(true) };

  const signUp = (values) => {
    httpPost('api/register/', {
      values,
    });
  };

  const signIn = (values) => {
    httpPost('api/register/', {
      values,
    });
  };

  return (
    <div>
      <div className={sign ? `${styles.container} ${styles.sign_up_mode}` : styles.container}>
        <div className={styles.forms_container}>
          <div className={styles.signin_signup}>
            <SignIn onSubmit={signIn} />
            <SignUp onSubmit={signUp} />
          </div>
        </div>
        <div className={styles.panels_container}>
          <div className={`${styles.panel} ${styles.left_panel}`}>
            <div className={styles.content}>
              <h3>¿Nuevo en Santero?</h3>
              {/* <p>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Debitis,
                ex ratione. Aliquid!
              </p> */}
              <button onClick={SwitchSign} className={`${styles.btn} ${styles.transparent}`} id="sign_up_btn">
                Registrarse
              </button>
            </div>
            <img src={Logo} className={styles.image} alt="" />
          </div>
          <div className={`${styles.panel} ${styles.right_panel}`}>
            <div className={styles.content}>
              <h3>¿Ya tenes cuenta?</h3>
              {/* <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum
                laboriosam ad deleniti.
              </p> */}
              <button onClick={SwitchSign} className={`${styles.btn} ${styles.transparent}`} id="sign_in_btn">
                Iniciar Sesión
              </button>
            </div>
            <img src={Register} className={styles.image} alt="" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Sign;