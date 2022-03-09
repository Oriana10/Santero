package com.Santero.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Santero.entities.Cart;
import com.Santero.entities.ClientOrder;
import com.Santero.entities.Delivery;
import com.Santero.entities.Payment;
import com.Santero.enums.TypeOfPayment;
import com.Santero.repositories.PaymentRepository;

@Service
/**
 * @author Nicolas
 */
public class PaymentService {
	
	@Autowired
	private Validator validator;

	@Autowired
	private PaymentRepository paymentRepository;
	
	// Create
	// Este método guarda y retorna una orden como objeto. Se puede usar para crear o editar.
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Payment save(Payment payment) {
		validator.notNullObject(payment, "Payment");
		return paymentRepository.save(payment);
	}
	
	// Este método obtiene todos los atributos de un pago y crea un objeto usando los mismos. Se puede usar para crear o editar.
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Payment save(String expiryDate, String cardHolder, TypeOfPayment typeOfPayment, String discount, Float paymentAmount, Cart cart, Delivery delivery, ClientOrder order) {
		List<Object> objects = Arrays.asList(expiryDate, cardHolder, typeOfPayment, discount, paymentAmount, cart, delivery, order);
		List<String> names = Arrays.asList("ExpiryDate", "CardHolder", "TypeOfPayment", "Discount", "PaymentAmount", "Cart", "Delivery", "Order");
		validator.notNullObjects(objects, names);
		
		Payment payment = new Payment();
		payment.setExpiryDate(expiryDate);
		payment.setCardHolder(cardHolder);
		payment.setTypeOfPayment(typeOfPayment);
		payment.setDiscount(discount);
		payment.setPaymentAmount(paymentAmount);
		payment.setCart(cart);
		payment.setDelivery(delivery);
		payment.setClientOrder(order);
		
		return paymentRepository.save(payment);
	}
	
	// Delete
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void delete(Payment payment) {
		validator.notNullObject(payment, "Payment");
		paymentRepository.delete(payment);
	}
	
	// List-all
	@Transactional(readOnly = true) // Transaccion de solo lectura (no va a cambiar el estado en nuestra base de datos)
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}
	
	// findById
	@Transactional(readOnly = true)
	public Optional<Payment> findById(String id) {
		validator.notNullObject(id, "idPayment");
		return paymentRepository.findById(id);
	}
	
	// getById
	@Transactional(readOnly = true)
	public Payment getById(String id) {
		validator.notNullObject(id, "idPayment");
		return paymentRepository.getById(id);
	}
	
	
	
}
