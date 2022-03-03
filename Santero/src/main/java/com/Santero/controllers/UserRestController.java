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

import com.Santero.entities.User;
import com.Santero.services.UserService;

@RestController
@RequestMapping("/user")
/**
 * @author Lamberti
 */
public class UserRestController {

	//Los nombres de los mapeos son de prueba. Pueden cambiarse en todo momento.
	
	@Autowired
	private UserService userService;
	/**
	 * @author Franco Lamberti
	 * Este método retorna todos los usuarios actuales
	 */
	@GetMapping("/users-list")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el usuario guardado con un código 200
	 */
	@GetMapping("/save/{id}")
	public ResponseEntity<User> save(@RequestBody User User) throws Exception{//Transformo en un objeto los datos recibidos
		User obj = userService.save(User); //Guardo al User que obtuve
		return new ResponseEntity<User>(obj, HttpStatus.OK);//Retorno un ResponseEntity igual al User guardado y un Status 200(OK)
	}
	
	/**
	 * @author Franco Lamberti
	 * Este método retorna el usuario eliminado. Puede dar un código 200 en caso de que se elimine correctamente o un 500 en caso de que no se pueda eliminar
	 */
	@PostMapping("/delete/{id}")
	public ResponseEntity<User> delete(@PathVariable("id") String id) throws Exception{
		User user = userService.getById(id);
		if(user != null) {//Si User no es nulo lo borro
			userService.delete(user);
		}else {
			//Si es nulo tiro un error 500
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//Si no es nulo, retorna el user y un 200
		return new ResponseEntity<User>(user, HttpStatus.OK);		
	}
	
}
