package com.Santero.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Cart;
import com.Santero.entities.Client;
import com.Santero.entities.ClientOrder;
import com.Santero.entities.Product;
import com.Santero.exceptions.CustomDataNotFoundException;
import com.Santero.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired 
	private ProductService productService;
	
	public Cart saveCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Cart saveCart(Float totalCost, Client client, ClientOrder order) {
		
		Cart cart = new Cart();
		cart.setTotalCost(totalCost);
		cart.setUser(client);
		cart.setClientOrder(order);
		
		return cartRepository.save(cart);
	}
	
	public void addProducts(String idCart, Product product)  {
		List<Product> productList = productService.createlistProducts(product);
		
		Cart cart = this.getById(idCart);
		
		cart.setProductList(productList);
		
		cartRepository.save(cart);
	}
	
	public void removeProduct(String idCart, Product product) {
		List<Product> productList = this.listProducts(idCart);
		Iterator<Product> ite = productList.iterator();
		
		while(ite.hasNext()) {
			Product p = (Product) ite.next();
			if (p.getIdProduct().equals(product.getIdProduct())) {
				ite.remove();
				Cart cart = this.getById(idCart);
				cart.setProductList(productList);
				cartRepository.save(cart);
			}
		}
	}
	
	public List<Product> listProducts(String idCart) {
		Cart cart = this.getById(idCart);
		return cart.getProductList();
	}
	
	public Cart getById(String idCart) {
		
		Optional<Cart> answer  = cartRepository.findById(idCart);
		
		if (answer.isEmpty()) {
			throw new CustomDataNotFoundException("No se encontró el carro");
		} else {
			return answer.get();
		}
	}
	
	public void deleteCart(String idCart) {
		
		Optional<Cart> answer = cartRepository.findById(idCart);
		
		if(answer.isPresent()) {
			Cart cart = answer.get();
			cartRepository.delete(cart);
		} else {
			throw new CustomDataNotFoundException("No se encontro el carro a borrar.");
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
