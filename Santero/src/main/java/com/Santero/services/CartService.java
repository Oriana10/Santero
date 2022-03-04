package com.Santero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Cart;
import com.Santero.entities.Product;
import com.Santero.enums.ProductCategory;
import com.Santero.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired 
	private ProductService productService;
	
	public Cart newCart(Float totalCost, User user, Order order) {
		
		Cart cart = new Cart();
		cart.setTotalCost(totalCost);
		cart.setUser(user);
		cart.setOrder(order);
		
		return cartRepository.save(cart);
	}
	
	public void addProducts(String idCart, String productName, Float productPrice, String description, ProductCategory productCategory, Integer stock, String productImage, Cart cart) throws Exception {
		List<Product> productList = productService.listProducts(idCart, productName, productPrice, description, productCategory, stock, productImage, cart);
		
		Cart cart2 = this.findById(idCart);
		
		cart2.setProductList(productList);
		
		cartRepository.save(cart2);
	}
	
	public List<Product> listProducts(String idCart) throws Exception{
		Cart cart = this.findById(idCart);
		return cart.getProductList();
	}
	
	public Cart findById(String idCart) throws Exception{
		
		Optional<Cart> answer  = cartRepository.findById(idCart);
		
		if (answer.isEmpty()) {
			throw new Exception("No se encontró el carro");
		} else {
			return answer.get();
		}
	}
	

	/**public Cart editProductList(String idCart, List<Product> productList, String idProduct) throws Exception {
		
		Optional<Cart> answer = cartRepository.findById(idCart);
		
		if(answer.isPresent()) {
			Cart cart = answer.get();
			
			
			
		} else {
			throw new Exception("No se encontro el carrito buscado.");
		}
		
	}
	**/

}
