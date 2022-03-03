package com.Santero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Delivery;
import com.Santero.repositories.DeliveryRepository;


@Service
/**
 * @author Nicolas
 */
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	// Create
	public Delivery save(Delivery delivery) throws Exception {
		// Validation
		
		return deliveryRepository.save(delivery);
	}
	
	// Delete
	public void delete(Delivery delivery) throws Exception {
		// Validation
		
		deliveryRepository.delete(delivery);
	}
	
	// List-all
	public List<Delivery> getAll() {
		return deliveryRepository.findAll();
	}
	
	// getById
	public Delivery getById(String id) throws Exception{
		Optional<Delivery> result = deliveryRepository.findById(id);
		
		if(!result.isPresent()) {
			throw new Exception("Delivery not found");
		} else {
			Delivery delivery = result.get();
			return delivery;
		}
	}
}
