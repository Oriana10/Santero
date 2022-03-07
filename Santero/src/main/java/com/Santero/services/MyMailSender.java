package com.Santero.services;
/**
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Santero.entities.Product;

@Service
public class MyMailSender {

	@Autowired
	private JavaMailSender MyMailSender;

	@Autowired
	private Validator validator;

	public void enviarMail(String nombre, String email, String mensaje, Product product) throws Exception {

		try {
			List<Object> objects = Arrays.asList(nombre, email, mensaje, product);
			List<String> names = Arrays.asList("Nombre", "Email", "Mensaje", "Producto");			
			validator.notNullObjects(objects, names);			

			// Este mensaje nos llega a nuestro mail para saber quienes se comunicaron con nosotros:
			SimpleMailMessage message1 = new SimpleMailMessage();
			message1.setFrom("examplefelgnoreply@gmail.com");
			message1.setTo("examplefelgnoreply@gmail.com");
			message1.setSubject("Un usuario realizó una consulta:");
			message1.setText(nombre + ", cuyo mail es " + email + ", envió el siguiente mensaje: " + "\n" + mensaje);

			MyMailSender.send(message1);

			// Este es el mensaje que se les envía a los usuarios:
			SimpleMailMessage message2 = new SimpleMailMessage();
			message2.setFrom("examplefelgnoreply@gmail.com");
			message2.setTo(email);
			message2.setSubject("¡Bienvenido a Santero's!");
			message2.setText("Gracias "+ nombre +" por visitarnos, esperamos que disfrute de nuestra página y comidas. \n"
					+ "Usted compró: " + "*insertar cantidad* " + product.getProductName() + " y tiene " + "*inserte tiempo de demora* \n"+
					"¿Le gustaría contarnos su experiencia? \n *insertar form*");
							

			MyMailSender.send(message2);

		} catch (Exception e) {
			throw e;
		}
		
	}
	
}**/