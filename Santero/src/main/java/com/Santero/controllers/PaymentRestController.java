package com.Santero.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Santero.entities.Payment;
import com.Santero.services.PaymentService;

@RestController
@RequestMapping("/payment")
/**
 * @author Nicolas
 */
public class PaymentRestController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment-list")
	public List<Payment> getAll(){
		return paymentService.getAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Payment> save(@RequestBody Payment payment) throws Exception{ //Transformo en un objeto los datos recibidos
		Payment obj = paymentService.save(payment); //Guardo al Payment que obtuve
		return new ResponseEntity<Payment>(obj, HttpStatus.OK); //Retorno un ResponseEntity igual al Payment guardado y un Status 200(OK)
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Payment> delete(@PathVariable("idPayment") String idPayment) throws Exception{
		Payment obj = paymentService.getById(idPayment);
		if(obj != null) {//Si Payment no es nulo lo borro
			paymentService.delete(obj);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Payment>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el payment y un 200
		return new ResponseEntity<Payment>(obj, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> read(@PathVariable("idPayment") String idPayment) throws Exception{
		Optional<Payment> obj = paymentService.findById(idPayment);
		
		if(!obj.isPresent()) {
			return new ResponseEntity<Payment>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Payment>(obj.get(), HttpStatus.OK);	
	}
	
	/*
	@PutMapping("/update/{id}")
	public ResponseEntity<Payment> update(@RequestBody Payment payment, @PathVariable("id") String id) throws Exception{
		Optional<Payment> obj = paymentService.findById(id);
		
		if(!obj.isPresent()) {
			return new ResponseEntity<Payment>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		// BeanUtils -> Setea el objeto entero si tambien queremos actualizar el id
		// BeanUtils.copyProperties(payment, obj.get());
		
		obj.get().setExpiryDate(payment.getExpiryDate());
		obj.get().setCardHolder(payment.getCardHolder());
		obj.get().setTypeOfPayment(payment.getTypeOfPayment());
		obj.get().setDiscount(payment.getDiscount());
		obj.get().setPaymentAmount(payment.getPaymentAmount());
		obj.get().setCart(payment.getCart());
		obj.get().setDelivery(payment.getDelivery());
		obj.get().setOrder(payment.getOrder());
		
		return new ResponseEntity<Payment>(paymentService.save(obj.get()), HttpStatus.OK);
	}
	*/
	

}
