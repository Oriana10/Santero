package com.Santero.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.Santero.enums.ProductCategory;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idProduct;
	private String productName;
	private String productPrice;
	private String description;
	@Enumerated(EnumType.STRING)
	private ProductCategory productCategory;
	private Integer stock;
	private String productImage;
	@OneToOne
	private Cart cart;
	
	public Product() {
		
	}

	public Product(String idProduct, String productName, String productPrice, String description,
			ProductCategory productCategory, Integer stock, String productImage, Cart cart) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.productCategory = productCategory;
		this.stock = stock;
		this.productImage = productImage;
		this.cart = cart;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}		
		
}
