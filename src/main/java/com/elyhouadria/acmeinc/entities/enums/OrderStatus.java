package com.elyhouadria.acmeinc.entities.enums;

public enum OrderStatus {
	
	Pending,
	Shipped,
	Delivered,
	Refunded;

	@Override
	public String toString() {
		return name();
	}
}
