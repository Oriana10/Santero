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

import com.Santero.entities.ClientOrder;
import com.Santero.services.ClientOrderService;

@RestController
@RequestMapping("/ClientOrder")
/**
 * @author Lamberti
 */
public class ClientOrderRestController {


	//Los nombres de los mapeos son de prueba. Pueden cambiarse en todo momento.
	
	@Autowired
	private ClientOrderService ClientOrderService;
	/**
	 * @author Franco Lamberti
	 * Este método retorna todas las ordenes actuales
	 */
	@GetMapping("/list")
	public List<ClientOrder> getAll(){
		return ClientOrderService.getAll();
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método devuelve un único cliente segun su ID
	 * @throws Exception 
	 */
	@GetMapping("/find/{id}")
	public ClientOrder find(@PathVariable String id) {
		return ClientOrderService.getById(id);
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna la orden guardada con un código 200
	 */
	@GetMapping("/save/{id}")
	public ResponseEntity<ClientOrder> save(@RequestBody ClientOrder ClientOrder) {//Transformo en un objeto los datos recibidos
		ClientOrder obj = ClientOrderService.save(ClientOrder); //Guardo la ClientOrder que obtuve
		return new ResponseEntity<ClientOrder>(obj, HttpStatus.OK);//Retorno un ResponseEntity igual al ClientOrder guardado y un Status 200(OK)
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el ClientOrder eliminado. Puede dar un código 200 en caso de que se elimine correctamente o un 500 en caso de que no se pueda eliminar
	 */
	@PostMapping("/delete/{id}")
	public ResponseEntity<ClientOrder> delete(@PathVariable("id") String id) {
		ClientOrder ClientOrder = ClientOrderService.getById(id);
		if(ClientOrder != null) {//Si ClientOrder no es nulo lo borro
			ClientOrderService.delete(ClientOrder);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<ClientOrder>(ClientOrder, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el ClientOrder y un 200
		return new ResponseEntity<ClientOrder>(ClientOrder, HttpStatus.OK);		
	}
	
}
