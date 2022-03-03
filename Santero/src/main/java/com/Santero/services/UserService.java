package com.Santero.services;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Cart;
import com.Santero.entities.User;
import com.Santero.enums.Role;
import com.Santero.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Validator validator;
	//Create
	/**
	 * @author Franco Lamberti
	 * Este método recibe un objeto User y lo guarda. Sirve para crear y editar un usuario. Si el usuario es nulo lanza una excepción.
	 * @param user - Es el usuario que vamos a guardar pasado como entidad
	 * @return - Se añade el return para que se pueda usar tanto solo como para guardar el usuario o bien para devolver el usuario creado, sin la necesidad de crear otro método que sea igual pero que retorne void.
	 * @throws Exception 
	 */
	public User save(User user) throws Exception {
		validator.notNullObject(user, "User");
		return userRepository.save(user);
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método recibe los atributos del usuario y los guarda. Sirve para crear y editar un usuario. Si algun atributo es nulo, lanza una excepción. 
	 * @param name
	 * @param surname
	 * @param role
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param dni
	 * @param cart
	 */
	public User save(String name, String surname, Role role, String password, String email, Long phoneNumber, String address, Long dni, Cart cart) throws Exception {
		List<Object> objects = Arrays.asList(name, surname, role, password, email, phoneNumber, address, dni, cart);
		List<String> names = Arrays.asList("Name", "Surname", "Role", "Password", "Email", "PhoneNumber", "Address", "dni", "Cart");
		validator.notNullObjects(objects, names);
		
		User user = new User();		
		user.setAddress(address);
		user.setCart(cart);
		user.setDni(dni);
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);
		user.setSurname(surname);
		
		return userRepository.save(user);		
	}

	//Delete
	public void delete(User user) throws Exception {
		validator.notNullObject(user, "User");
		userRepository.delete(user);
	}
	
	//Getters
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getById(String id) {
		return userRepository.getById(id);
	}
	
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}
		
}
