import Product from "./subComponents/Product";
import {  httpGet } from '../utils/HttpFunctions'

import { useEffect, useState } from 'react'


function ProductView() {

  const [product, setProduct] = useState([])

  const fetchProduct = () => {
    httpGet(`api/product/`)
      .then((res) => setProduct(res.data))
  }

  useEffect(fetchProduct, [])

  return (
  <>
    <Product productName={product.name} productDescription={product.description} price={product.price} />
  </>
  )
}


export default ProductView;