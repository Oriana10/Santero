package com.Santero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santero.exceptions.CustomDataNotFoundException;

@Service
/**
 * @author Franco Lamberti
 * Este servicio permite validar de forma rápida un objeto o varios. Es genérico por lo que se puede enviar cualquier objeto (int, long, Client, String, etc).
 */
public class Validator {

	/**
	 * @author Franco Lamberti
	 * Valida si un objeto es nulo. Si es nulo, lanza una excepción.
	 * @param value - Es el elemento que queremos validar que no sea nulo
	 * @param name - Es el nombre con el que queremos que aparezca en consola si llega a lanzar una excepción. 
	 */
	public void notNullObject(Object value, String name) {
		if(value == null)
			throw new CustomDataNotFoundException(name + " can't be null");
	}
	
	/**
	 * @author Franco Lamberti
	 * Valida muchos objetos a la vez. Si uno es uno, lanza una excepción.
	 * @param values - Son todos los objetos que queremos validar
	 * @param names - Son los nombres de cada objeto que queremos validar. Deben coincidir con el indice de "values".
	 */
	public void notNullObjects(List<Object> values, List<String> names) {
		for(int i = 0; i < values.size(); i++) {
			if(values.get(i) == null)
				throw new CustomDataNotFoundException(names.get(i) + " can't be null");
		}
		
	}
	
}
