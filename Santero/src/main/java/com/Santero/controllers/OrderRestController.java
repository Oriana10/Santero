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

import com.Santero.entities.Order;
import com.Santero.services.OrderService;

@RestController
@RequestMapping("/order")
/**
 * @author Lamberti
 */
public class OrderRestController {


	//Los nombres de los mapeos son de prueba. Pueden cambiarse en todo momento.
	
	@Autowired
	private OrderService orderService;
	/**
	 * @author Franco Lamberti
	 * Este método retorna todas las ordenes actuales
	 */
	@GetMapping("/list")
	public List<Order> getAll(){
		return orderService.getAll();
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método devuelve un único cliente segun su ID
	 * @throws Exception 
	 */
	@GetMapping("/find/{id}")
	public Order find(@PathVariable String id) {
		return orderService.getById(id);
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna la orden guardada con un código 200
	 */
	@GetMapping("/save/{id}")
	public ResponseEntity<Order> save(@RequestBody Order Order) {//Transformo en un objeto los datos recibidos
		Order obj = orderService.save(Order); //Guardo la Order que obtuve
		return new ResponseEntity<Order>(obj, HttpStatus.OK);//Retorno un ResponseEntity igual al Order guardado y un Status 200(OK)
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el Order eliminado. Puede dar un código 200 en caso de que se elimine correctamente o un 500 en caso de que no se pueda eliminar
	 */
	@PostMapping("/delete/{id}")
	public ResponseEntity<Order> delete(@PathVariable("id") String id) {
		Order Order = orderService.getById(id);
		if(Order != null) {//Si Order no es nulo lo borro
			orderService.delete(Order);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Order>(Order, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el Order y un 200
		return new ResponseEntity<Order>(Order, HttpStatus.OK);		
	}
	
}
