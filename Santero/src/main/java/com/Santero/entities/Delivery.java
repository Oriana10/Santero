package com.Santero.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
/**
 * @author Nicolas
 */
public class Delivery {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String idDelivery;
	
	@Column(nullable = false)
	private Boolean isSent;
	
	@Column(nullable = false)
	private Float cost;
	
	@Column(nullable = false)
	private String delay;
	
	@Column(nullable = false)
	private String comments;
	
	@Column(nullable = false)
	private String adress;
	
	@OneToOne
	private Payment payment;

	public Delivery() {
		super();
	}

	public Delivery(String idDelivery, Boolean isSent, Float cost, String delay, String comments, String adress,
			Payment payment) {
		super();
		this.idDelivery = idDelivery;
		this.isSent = isSent;
		this.cost = cost;
		this.delay = delay;
		this.comments = comments;
		this.adress = adress;
		this.payment = payment;
	}

	public String getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(String idDelivery) {
		this.idDelivery = idDelivery;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
		
}
