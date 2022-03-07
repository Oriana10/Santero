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
}
