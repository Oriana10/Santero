package com.Santero.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.Santero.enums.ProductCategory;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idProduct;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private Float productPrice;
	@Column(nullable = false)
	private String description;
	@Enumerated(EnumType.STRING)
	private ProductCategory productCategory;
	@Column(nullable = false)
	private Integer stock;
	private String productImage;
	
	@ManyToOne
	@JoinColumn(name = "productList")
	private Cart cart;		
		
}
