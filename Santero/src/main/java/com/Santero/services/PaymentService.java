package com.Santero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santero.entities.Payment;
import com.Santero.repositories.PaymentRepository;

@Service
/**
 * @author Nicolas
 */
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	// Create
	public Payment save(Payment payment) throws Exception {
		// Validation
		
		return paymentRepository.save(payment);
	}
	
	// Delete
	public void delete(Payment payment) throws Exception {
		// Validation
		
		paymentRepository.delete(payment);
	}
	
	// List-all
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}
	
	// getById
	public Payment getById(String id) throws Exception{
		Optional<Payment> result = paymentRepository.findById(id);
		
		if(!result.isPresent()) {
			throw new Exception("Payment not found");
		} else {
			Payment payment = result.get();
			return payment;
		}
	}
	
}
