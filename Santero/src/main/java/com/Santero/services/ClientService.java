package com.Santero.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Santero.entities.Cart;
import com.Santero.entities.Client;
import com.Santero.enums.Role;
import com.Santero.repositories.ClientRepository;

@Service
public class ClientService implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private Validator validator;

	// Create
	/**
	 * @author Franco Lamberti Este método recibe un objeto Client y lo guarda.
	 *         Sirve para crear y editar un usuario. Si el usuario es nulo lanza una
	 *         excepción.
	 * @param client - Es el usuario que vamos a guardar pasado como entidad
	 * @return - Se añade el return para que se pueda usar tanto solo como para
	 *         guardar el usuario o bien para devolver el usuario creado, sin la
	 *         necesidad de crear otro método que sea igual pero que retorne void.
	 * @throws Exception
	 */
	public Client save(Client client) throws Exception {
		validator.notNullObject(client, "Client");
		return clientRepository.save(client);
	}

	/**
	 * @author Franco Lamberti Este método recibe los atributos del usuario y los
	 *         guarda. Sirve para crear y editar un usuario. Si algun atributo es
	 *         nulo, lanza una excepción.
	 * @param name
	 * @param surname
	 * @param role
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param dni
	 * @param cart
	 */
	public Client save(String name, String surname, Role role, String password, String email, Long phoneNumber,
			String address, Long dni, Cart cart) throws Exception {
		List<Object> objects = Arrays.asList(name, surname, role, password, email, phoneNumber, address, dni, cart);
		List<String> names = Arrays.asList("Name", "Surname", "Role", "Password", "Email", "PhoneNumber", "Address",
				"dni", "Cart");
		validator.notNullObjects(objects, names);

		Client client = new Client();
		client.setAddress(address);
		client.setCart(cart);
		client.setDni(dni);
		client.setEmail(email);
		client.setName(name);
		String encPass = new BCryptPasswordEncoder().encode(password);// Encripto la contraseña
		client.setPassword(encPass);// Setteo el encrypt
		client.setPhoneNumber(phoneNumber);
		client.setRole(role);
		client.setSurname(surname);

		return clientRepository.save(client);
	}

	// Delete
	public void delete(Client client) throws Exception {
		validator.notNullObject(client, "Client");
		clientRepository.delete(client);
	}

	// Getters
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	public Client getById(String id) {
		return clientRepository.getById(id);
	}

	public Client getByEmail(String email) {
		return clientRepository.getByEmail(email);
	}

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Client> opt = clientRepository.getOptionalByEmail(email);//Obtengo un optional del usuario segun su email
		if (opt.isPresent()) {//Si existe un usuario con este mail...
			Client client = opt.get();//Lo obtengo

			// Creación de permisos
			List<GrantedAuthority> authorities = new ArrayList();

			GrantedAuthority authority1 = new SimpleGrantedAuthority( Role.CLIENT.toString() ); //Creo una authority que sea igual a mi rol CLIENT, como no es string le hago un toString
			authorities.add(authority1);//Le setteo este permiso a la lista de authorities

			// Sesión de usuario
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); //Obtengo los atributos del request actual
			HttpSession session = attr.getRequest().getSession(true);//Obtengo los datos de sesión de la request

			session.setAttribute("usersession", client);//Añado un atributo a la sesión igual a mi cliente logueado

			// Usuario logeado, con sus respectivos permisos.
			User user = new User(client.getEmail(), client.getPassword(), authorities);//Creo un usuario de Spring igual a su mail, contraseña y authorities
			return user;
		} else {
			return null;//Si no hay usuarios con este email, retorno null
		}
	}

}
