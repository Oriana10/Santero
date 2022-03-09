package com.Santero.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Cart;
import com.Santero.entities.Client;
import com.Santero.entities.ClientOrder;
import com.Santero.entities.Payment;
import com.Santero.repositories.ClientOrderRepository;

@Service
/**
 * @author Lamberti
 */
public class ClientOrderService {

	@Autowired
	private Validator validator;
	
	@Autowired
	private ClientOrderRepository ClientOrderRepository;
	
	//Create
	/**
	 * @author Franco Lamberti
	 * Este método guarda y retorna una orden como objeto. Se puede usar para crear o editar.
	 * @param ClientOrder - Es la orden a guardar
	 */
	public ClientOrder save(ClientOrder ClientOrder) {
		validator.notNullObject(ClientOrder, "ClientOrder");
		return ClientOrderRepository.save(ClientOrder);
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método obtiene todos los atributos de una orden y crea un objeto usando los mismos. Se puede usar para crear o editar.
	 * @param number
	 * @param cart
	 * @param client
	 * @param payment
	 */
	public ClientOrder save(Long number, Cart cart, Client client, Payment payment) {
		List<Object> objects = Arrays.asList(number, cart, client, payment);
		List<String> names = Arrays.asList("Number", "Cart", "Client", "Payment");
		validator.notNullObjects(objects, names);
		
		ClientOrder ClientOrder = new ClientOrder();
		ClientOrder.setCart(cart);
		ClientOrder.setNumber(number);
		ClientOrder.setPayment(payment);
		ClientOrder.setUser(client);
		
		return ClientOrderRepository.save(ClientOrder);
	}
	
	//Delete
	public void delete(ClientOrder ClientOrder) {
		validator.notNullObject(ClientOrder, "ClientOrder");
		ClientOrderRepository.delete(ClientOrder);
	}
	
	//Getters
	public List<ClientOrder> getAll(){
		return ClientOrderRepository.findAll();
	}
	
	public ClientOrder getById(String id) {
		validator.notNullObject(id, "Id");
		return ClientOrderRepository.getById(id);
	}
}
