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

import com.Santero.entities.Delivery;
import com.Santero.services.DeliveryService;


@RestController
@RequestMapping("/delivery")
/**
 * @author Nicolas
 */
public class DeliveryRestController {

	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping("/delivery-list")
	public List<Delivery> getAll(){
		return deliveryService.getAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Delivery> save(@RequestBody Delivery delivery) { //Transformo en un objeto los datos recibidos
		Delivery obj = deliveryService.save(delivery); //Guardo al Delivery que obtuve
		return new ResponseEntity<Delivery>(obj, HttpStatus.OK); //Retorno un ResponseEntity igual al Delivery guardado y un Status 200(OK)
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<Delivery> delete(@PathVariable("idDelivery") String idDelivery) {
		Delivery obj = deliveryService.getById(idDelivery);
		if(obj != null) {//Si Delivery no es nulo lo borro
			deliveryService.delete(obj);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Delivery>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el Delivery y un 200
		return new ResponseEntity<Delivery>(obj, HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Delivery> read(@PathVariable("idDelivery") String idDelivery) {
		Optional<Delivery> obj = deliveryService.findById(idDelivery);
		
		if(!obj.isPresent()) {
			return new ResponseEntity<Delivery>(obj.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Delivery>(obj.get(), HttpStatus.OK);
	}
}
