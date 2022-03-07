package com.Santero.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Santero.entities.Delivery;
import com.Santero.entities.Payment;
import com.Santero.repositories.DeliveryRepository;
import com.Santero.repositories.PaymentRepository;


@Service
/**
 * @author Nicolas
 */
public class DeliveryService {
	
	@Autowired
	private Validator validator;

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	// Create
	// Este método guarda y retorna una orden como objeto. Se puede usar para crear o editar.
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Delivery save(Delivery delivery) throws Exception {
		validator.notNullObject(delivery, "Delivery");
		return deliveryRepository.save(delivery);
	}
	
	// Este método obtiene todos los atributos de un pago y crea un objeto usando los mismos. Se puede usar para crear o editar.
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Delivery save(Boolean isSent, Float cost, String delay, String comments, String adress, Payment payment) throws Exception {
		List<Object> objects = Arrays.asList(isSent, cost, delay, comments, adress, payment);
		List<String> names = Arrays.asList("IsSent", "Cost", "Delay", "Comments", "Adress", "Payment");
		validator.notNullObject(objects, names);
		
		Delivery delivery = new Delivery();
		delivery.setIsSent(isSent);
		delivery.setCost(cost);
		delivery.setDelay(delay);
		delivery.setComments(comments);
		delivery.setAdress(adress);
		delivery.setPayment(payment);
		
		deliveryRepository.save(delivery);
	}
	
	// Delete
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Delivery delivery) throws Exception {
		validator.notNullObject(delivery, "Delivery");
		deliveryRepository.delete(delivery);
	}
	
	// List-all
	@Transactional(readOnly = true) // Transaccion de solo lectura (no va a cambiar el estado en nuestra base de datos)
	public List<Delivery> getAll() {
		return deliveryRepository.findAll();
	}
	
	// findById
	@Transactional(readOnly = true)
	public Optional<Delivery> findById(String id) throws Exception {
		validator.notNullObject(id, "idDelivery");
		return deliveryRepository.findById(id);
	}
	
	// getById
	@Transactional(readOnly = true)
	public Delivery getById(String id) throws Exception{
		validator.notNullObject(id, "idDelivery");
		return deliveryRepository.getById(id);
	}

}
