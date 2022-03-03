package com.Santero.enums;

public enum Role {

	ADMIN("Admin"), CLIENT("Client");
	
	private final String role;
	
	private Role(String role) {
		this.role = role;
	}
	
	private String getRole() {
		return role;
	}
	
	
}
