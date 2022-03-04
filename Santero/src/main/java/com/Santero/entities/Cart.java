package com.Santero.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idCart;
	private List<String> productList;
	private Float totalCost;
	
	@OneToOne
	private Client client;
	@OneToOne Order order;
	
	
	public Cart() {
		
	}


	public Cart(String idCart, List<String> productList, Float totalCost, Client client, Order order) {
		super();
		this.idCart = idCart;
		this.productList = productList;
		this.totalCost = totalCost;
		this.client = client;
		this.order = order;
	}


	public String getIdCart() {
		return idCart;
	}


	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}


	public List<String> getProductList() {
		return productList;
	}


	public void setProductList(List<String> productList) {
		this.productList = productList;
	}


	public Float getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}


	public Client getUser() {
		return client;
	}


	public void setUser(Client client) {
		this.client = client;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}	
		
}
