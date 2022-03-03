package com.Santero.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.Santero.enums.Role;

@Entity
/**
 * @author Lamberti
 */
public class User {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(nullable = false)
	private String password;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = true, nullable = false)
	private Long phoneNumber;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private Long dni;
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Order> orders;
	
	@OneToOne
	private Cart cart;

	public User(){}

	public User(String id, String name, String surname, Role role, String password, String email, Long phoneNumber,
			String address, Long dni, List<Order> orders, Cart cart) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dni = dni;
		this.orders = orders;
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
