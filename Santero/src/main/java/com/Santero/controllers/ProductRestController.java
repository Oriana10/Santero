package com.Santero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Santero.entities.Product;
import com.Santero.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product-list")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product obj = productService.saveProduct(product);
		return new ResponseEntity<Product>(obj, HttpStatus.OK);
	}
		
	@GetMapping("/delete/{idProduct}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String idProduct) throws Exception{
		Product product = productService.getById(idProduct);
		if(product != null) {
			productService.deleteProduct(idProduct);
		}else {			
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{idProduct}")
	public Product findById(@PathVariable String idProduct) throws Exception {
		return productService.getById(idProduct);
	}
	
	@GetMapping("/findByName")
	public List<Product> findByName(@RequestParam(required = false) String q) {
		return productService.getByName(q);
	}
	
	@GetMapping("/findByCategory")
	public List<Product> findByCategory(@RequestParam(required = false) String q) {
		return productService.getByCategory(q);
	}
	
	@GetMapping("/findByPrice")
	public List<Product> findByPrice(@RequestParam(required = false) String q) {
		return productService.getByPrice(q);
	}
	
	@GetMapping("/findByPriceASC")
	public List<Product> findByPriceASC() {
		return productService.getByPriceASC();
	}
	
	@GetMapping("/findByPriceDESC")
	public List<Product> findByPriceDESC() {
		return productService.getByPriceDESC();
	}
}
