package com.elyhouadria.acmeinc.entities.enums;

public enum PayementType {
	
	PayPal,
	credit_card,
	Bank_Transfer
	;

	@Override
	public String toString() {
		return name();
	}
}
