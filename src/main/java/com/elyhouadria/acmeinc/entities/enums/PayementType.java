package com.elyhouadria.acmeinc.entities.enums;

public enum PayementType {
	
	paypal,
	credit_card,
	;

	@Override
	public String toString() {
		return name();
	}
}
