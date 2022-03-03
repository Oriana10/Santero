package com.Santero.controllers;

import java.util.List;

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
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("/payment-list")
	public List<Payment> getAll(){
		return paymentService.getAll();
	}
	
	@GetMapping("/save/{id}")
	public ResponseEntity<Payment> save(@RequestBody Payment payment) throws Exception{ //Transformo en un objeto los datos recibidos
		Payment obj = paymentService.save(payment); //Guardo al Payment que obtuve
		return new ResponseEntity<Payment>(obj, HttpStatus.OK); //Retorno un ResponseEntity igual al Payment guardado y un Status 200(OK)
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Payment> delete(@PathVariable("id") String id) throws Exception{
		Payment payment = paymentService.getById(id);
		if(payment != null) {//Si Payment no es nulo lo borro
			paymentService.delete(payment);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Payment>(payment, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el payment y un 200
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);		
	}
	

}
