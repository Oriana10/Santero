import { useField } from "formik"
import styles from '../sign.module.css'


const TextInput = ({ placeholder, i, ...props }) => {
  const [field, meta] = useField(props)
  return (
    <div className={styles.input_field}>
      <i className={i}></i>
      <input className={styles.input} placeholder={placeholder} {...field} {...props} />
      {meta.touched && meta.error ? <div className={styles.error}>{meta.error}</div> : null}
    </div>
  )
}

export default TextInput