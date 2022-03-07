package com.Santero.enums;

public enum TypeOfPayment {
	
	TARJETA_CREDITO("Tarjeta de Crédito"), TARJETA_DEBITO("Tarjeta de Débito"), MERCADO_PAGO("Mercado Pago"), EFECTIVO("Efectivo");
	
	private final String value;
	
	private TypeOfPayment(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
