import { useState } from 'react'
import styles from '../Product.module.css'
import Pizza from '../img/Pizza.png'


const Product = ({productName, productDescription, price}) => {

  const [productQuantity, setProductQuantity] = useState(1);

  const addQuantity = () => {
    setProductQuantity(productQuantity + 1);
  };

  const reduceQuantity = () => {
    if(productQuantity > 1){
    setProductQuantity(productQuantity - 1)
  } return null
  };

  return (
  <div className={styles.productContainer}>
    <img className={styles.productImg} src={Pizza} alt='' />

    <section className={styles.productInfo}>
    <h1>{productName}</h1>
    <p className={styles.productDescrption}>{productDescription}</p>

    <p className={styles.price}>Total: ${price * productQuantity}</p>
    <div className={styles.btnContainer}>
    <div className={styles.quantityContainer}>
    <button className={`${styles.btnQuantity} ${styles.reduce}`} onClick={reduceQuantity}>-</button>
    <div className={styles.quantity}><p>{productQuantity}</p></div>
    <button className={`${styles.btnQuantity} ${styles.add}`} onClick={addQuantity}>+</button>
    </div>
    <button className={styles.btnAddProduct} type='submit' >Añadir al carro</button>
    </div>
    </section>
  </div>
  )
}

export default Product;