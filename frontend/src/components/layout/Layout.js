import { Outlet } from 'react-router-dom';
import Footer from './Footer';
import Header from './Header';

import styles from './Layout.module.css';

function Layout() {
  return (
    <div className={styles.wrapper}>
      <div className={styles.container}>
        <div className={styles.main}>
          <Header />
          <div className={styles.content}>
            <Outlet />
          </div>
          <Footer />
        </div>
      </div>
    </div>
  );
}

export default Layout;
