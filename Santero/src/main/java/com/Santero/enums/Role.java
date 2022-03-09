package com.Santero.enums;

public enum Role {

	ADMIN("Admin"), CLIENT("Client");
	
	private final String role;
	
	private Role(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	
}
