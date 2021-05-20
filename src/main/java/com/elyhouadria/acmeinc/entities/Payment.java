package com.elyhouadria.acmeinc.entities;


import com.elyhouadria.acmeinc.entities.enums.PayementStatus;
import com.elyhouadria.acmeinc.entities.enums.PayementType;
import  com.elyhouadria.acmeinc.entities.enums.PayementStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Double amount;
	
	private String currency;
	
	@Enumerated(EnumType.STRING)
	private PayementStatus payementStatus;
	
	@Enumerated(EnumType.STRING)
	private PayementType payementType;
	
	@OneToOne(mappedBy="payment")
	private UserOrder userorder;

	public Payment() {}
	public Payment(Double amount, PayementStatus payementStatus, PayementType payementType, String currency) {
		this.amount = amount;
		this.payementStatus = payementStatus;
		this.payementType = payementType;
		this.currency = currency;
	}

	public Payment(Double amount, PayementStatus payementStatus, PayementType payementType, String currency, UserOrder userOrder) {
		this.amount = amount;
		this.payementStatus = payementStatus;
		this.payementType = payementType;
		this.currency = currency;
		this.userorder = userOrder;
	}
	public Payment(int id, Double amount, PayementStatus payementStatus, PayementType payementType, String currency, UserOrder userOrder) {
		this.id = id;
		this.amount = amount;
		this.payementStatus = payementStatus;
		this.payementType = payementType;
		this.currency = currency;
		this.userorder = userOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PayementStatus getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(PayementStatus payementStatus) {
		this.payementStatus = payementStatus;
	}

	public PayementType getPayementType() {
		return payementType;
	}

	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}

	public UserOrder getUserorder() {
		return userorder;
	}

	public void setUserOrder(UserOrder userorder) {
		this.userorder = userorder;
	}

	@Override
	public String toString() {
		return id + "amount: " + amount + "currency: " + currency + "payementStatus: " + payementStatus + "payementType : " + payementType;
//		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}