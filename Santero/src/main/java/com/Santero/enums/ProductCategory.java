package com.Santero.enums;

public enum ProductCategory {
	
	EMPANADAS("Empanadas"), TARTAS("Tartas"), 
	PIZZAS_Y_PIZZANESAS("Pizzas y Pizzanesas"), PAPAS("Papas"),
	VINAGRETAS ("Vinagretas"), VARIOS ("Varios"), PASTAS ("Pastas"), 
	LECHON ("Lechón"), BEBIDAS ("Bebidas"), POSTRES ("Postres");
	
	private final String value;
	
	private ProductCategory(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
