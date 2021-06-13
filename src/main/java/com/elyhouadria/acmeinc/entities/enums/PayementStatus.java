package com.elyhouadria.acmeinc.entities.enums;

public enum PayementStatus {
	
	Pending,
	Payed,
	Refunded;

	@Override
	public String toString() {
		return name();
	}
}
