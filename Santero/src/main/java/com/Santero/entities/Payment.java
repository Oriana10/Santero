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
	private ClientOrder ClientOrder;

	public Payment() {
		super();
	}

	public Payment(String idPayment, String expiryDate, String cardHolder, TypeOfPayment typeOfPayment, String discount,
			Float paymentAmount, Cart cart, Delivery delivery, ClientOrder ClientOrder) {
		super();
		this.idPayment = idPayment;
		this.expiryDate = expiryDate;
		this.cardHolder = cardHolder;
		this.typeOfPayment = typeOfPayment;
		this.discount = discount;
		this.paymentAmount = paymentAmount;
		this.cart = cart;
		this.delivery = delivery;
		this.ClientOrder = ClientOrder;
	}

	public String getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(String idPayment) {
		this.idPayment = idPayment;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public TypeOfPayment getTypeOfPayment() {
		return typeOfPayment;
	}

	public void setTypeOfPayment(TypeOfPayment typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public ClientOrder getClientOrder() {
		return ClientOrder;
	}

	public void setClientOrder(ClientOrder ClientOrder) {
		this.ClientOrder = ClientOrder;
	}	
		
}
