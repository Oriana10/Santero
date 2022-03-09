package com.Santero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Cart;
import com.Santero.entities.Product;
import com.Santero.enums.ProductCategory;
import com.Santero.exceptions.CustomDataNotFoundException;
import com.Santero.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product saveProduct(String productName, Float productPrice, String description, ProductCategory productCategory, Integer stock, String productImage, Cart cart) {
		
		Product product = new Product();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setDescription(description);
		product.setProductCategory(productCategory);
		product.setStock(stock);
		product.setProductImage(productImage);
		product.setCart(cart);
		
		return productRepository.save(product);
	}
	
	public List<Product> createlistProducts(Product product) {
		
		List<Product> listProducts = product.getCart().getProductList();
		listProducts.add(this.saveProduct(product));
		
		return listProducts;
	}
	
	public void deleteProduct(String idProduct) {
		
		Optional<Product> answer = productRepository.findById(idProduct);
		
		if(answer.isPresent()) {
			Product product = answer.get();
			productRepository.delete(product);
		} else {
			throw new CustomDataNotFoundException("No se encontro el producto a borrar.");
		}
		
	}
	
	public Product getById(String idProduct) {
		
		Optional<Product> answer = productRepository.findById(idProduct);
		
		if(answer.isEmpty()) {
			throw new CustomDataNotFoundException("No se encontro el producto a buscar");		
		} else {
			return answer.get();
		}
		
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getByCategory(String q){		
		return productRepository.getByCategory(q);
	}
	
	public List<Product> getByPrice(String q){		
		return productRepository.getByPrice(q);
	}
	
	public List<Product> getByPriceASC(){		
		return productRepository.getByPriceASC();
	}
	
	public List<Product> getByPriceDESC(){		
		return productRepository.getByPriceDESC();
	}
	
	public List<Product> getByName(String q){		
		return productRepository.getByName(q);
	}
	
	/**public Product editProduct(String idProduct, String productName, Float productPrice, String description, ProductCategory productCategory, Integer stock, String productImage, Cart cart) throws Exception {
	
	Optional<Product> answer = productRepository.findById(idProduct);
	
	if(answer.isPresent()) {
		
		Product product = answer.get();
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		product.setDescription(description);
		product.setProductCategory(productCategory);
		product.setStock(stock);
		product.setProductImage(productImage);
		product.setCart(cart);
		return productRepository.save(product);
		
	} else {
		
		throw new Exception("No se encontro el producto a editar.");
		
	}
	
}**/
}
