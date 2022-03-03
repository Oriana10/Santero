package com.Santero.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Enumerated;

import org.hibernate.annotations.GenericGenerator;

import com.Santero.enums.TypeOfPayment;

import lombok.Data;

@Entity
@Data
/**
 * @author Nicolas
 */
public class Payment {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idPayment;
	
	@Column(nullable = false)
	private String expiryDate;
	
	@Column(nullable = false)
	private String cardHolder;
	
	@Enumerated(EnumType.STRING)
	private TypeOfPayment typeOfPayment;
	
	@Column(nullable = false)
	private String discount;
	
	@Column(nullable = false)
	private Float paymentAmount;
	
	@OneToOne
	private Cart cart;
	
	@OneToOne
	private Delivery delivery;
	
	@OneToOne
	private Order order;
	
}
