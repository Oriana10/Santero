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

import com.Santero.entities.Delivery;
import com.Santero.services.DeliveryService;


@RestController
@RequestMapping("/delivery")
/**
 * @author Nicolas
 */
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	
	@GetMapping("/delivery-list")
	public List<Delivery> getAll(){
		return deliveryService.getAll();
	}
	
	@GetMapping("/save/{id}")
	public ResponseEntity<Delivery> save(@RequestBody Delivery delivery) throws Exception{ //Transformo en un objeto los datos recibidos
		Delivery obj = deliveryService.save(delivery); //Guardo al Delivery que obtuve
		return new ResponseEntity<Delivery>(obj, HttpStatus.OK); //Retorno un ResponseEntity igual al Delivery guardado y un Status 200(OK)
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<Delivery> delete(@PathVariable("id") String id) throws Exception{
		Delivery delivery = deliveryService.getById(id);
		if(delivery != null) {//Si Delivery no es nulo lo borro
			deliveryService.delete(delivery);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Delivery>(delivery, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el Delivery y un 200
		return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);		
	}
}
