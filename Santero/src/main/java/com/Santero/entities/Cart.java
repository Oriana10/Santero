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
	private Client client;

	@OneToOne 
	private ClientOrder order;

	public Cart() {
	}

	public Cart(String idCart, List<Product> productList, Float totalCost, Client client, ClientOrder order) {
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



	public Client getClient() {
		return client;
	}


	public void setUser(Client client) {
		this.client = client;
	}


	public ClientOrder getClientOrder() {
		return order;
	}


	public void setClientOrder(ClientOrder order) {
		this.order = order;
	}	
		
}
