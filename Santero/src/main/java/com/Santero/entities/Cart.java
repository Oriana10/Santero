package com.Santero.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idCart;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> productList;
	private Float totalCost;
	
	@OneToOne
	private User user;
	@OneToOne 
	private Order order;
	
	
	public Cart() {
		
	}


	public Cart(String idCart, List<Product> productList, Float totalCost, User user, Order order) {
		super();
		this.idCart = idCart;
		this.productList = productList;
		this.totalCost = totalCost;
		this.user = user;
		this.order = order;
	}


	public String getIdCart() {
		return idCart;
	}


	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	public Float getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}	
		
}
