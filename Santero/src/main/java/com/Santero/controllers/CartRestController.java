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
import org.springframework.web.bind.annotation.RestController;

import com.Santero.entities.Cart;
import com.Santero.entities.Product;
import com.Santero.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/save")
	public ResponseEntity<Cart> saveCart(@RequestBody Cart cart){
		Cart obj = cartService.saveCart(cart);
		return new ResponseEntity<Cart>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{idCart}")
	public ResponseEntity<Cart> deleteCart(@PathVariable String idCart){
		Cart cart = cartService.getById(idCart);
		if (cart != null) {
			cartService.deleteCart(idCart);
		} else {
			return new ResponseEntity<Cart>(cart, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{idCart}")
	public Cart findById(@PathVariable String idCart) {
		return cartService.getById(idCart);
	}
	
	@GetMapping("/list-products-in-it/{idCart}")
	public List<Product> listProducts(@PathVariable String idCart) {
		return cartService.listProducts(idCart);
	}
	
	@PostMapping("/add-products/{idCart}")
	public void addProducts(@PathVariable String idCart, @RequestBody Product product){
		cartService.addProducts(idCart, product);		
	}
	
	@PostMapping("/remove-products/{idCart}")
	public void removeProducts(@PathVariable String idCart, @RequestBody Product product){
		cartService.removeProduct(idCart, product);		
	}

}
