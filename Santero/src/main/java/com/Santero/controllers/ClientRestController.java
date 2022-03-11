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

import com.Santero.entities.Client;
import com.Santero.entities.Product;
import com.Santero.services.ClientService;
import com.Santero.services.MyMailSender;

@RestController
@RequestMapping("/client")
/**
 * @author Lamberti
 */
public class ClientRestController {

	//Los nombres de los mapeos son de prueba. Pueden cambiarse en todo momento.
	
	@Autowired
	private ClientService clientService;

	/**
	 * @author Franco Lamberti
	 * Este método retorna todos los usuarios actuales
	 * @throws Exception 
	 */
	@GetMapping("/list")
	public List<Client> getAll() throws Exception{
		return clientService.getAll();
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método devuelve un único cliente segun su ID
	 */
	@GetMapping("/find/{id}")
	public Client find(@PathVariable String id) {
		return clientService.getById(id);
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el usuario guardado con un código 200
	 */
	@GetMapping("/save")
	public ResponseEntity<Client> save(@RequestBody Client client) {//Transformo en un objeto los datos recibidos
		Client obj = clientService.save(client); //Guardo al Client que obtuve
		return new ResponseEntity<Client>(obj, HttpStatus.OK);//Retorno un ResponseEntity igual al Client guardado y un Status 200(OK)
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el usuario eliminado. Puede dar un código 200 en caso de que se elimine correctamente o un 500 en caso de que no se pueda eliminar
	 */
	@PostMapping("/delete/{id}")
	public ResponseEntity<Client> delete(@PathVariable("id") String id) {
		Client client = clientService.getById(id);
		if(client != null) {//Si Client no es nulo lo borro
			clientService.delete(client);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<Client>(client, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el user y un 200
		return new ResponseEntity<Client>(client, HttpStatus.OK);		
	}
	
}
