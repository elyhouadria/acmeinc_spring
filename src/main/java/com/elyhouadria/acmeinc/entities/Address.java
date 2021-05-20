package com.elyhouadria.acmeinc.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String lastName;
	private String firstName;
	private String addressLine1;
	private String addressLine2;
	private int zipCode;
	private String city;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;
	
	@OneToMany(mappedBy= "shippingAddress")
	private List<UserOrder> userOrdersAddress;

	public Address() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserOrder> getuserOrdersAddress() {
		return userOrdersAddress;
	}

	public void setOrdersAddress(List<UserOrder> userOrdersAddress) {
		this.userOrdersAddress = userOrdersAddress;
	}

	public Address(String lastName, String firstName, String addressLine1, String addressLine2, int zipCode, String city,
				   String country) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Address(String lastName, String firstName, String addressLine1, String addressLine2, int zipCode, String city, String country, User user) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.user = user;
		}

	public Address(int id, String lastName, String firstName, String addressLine1, String addressLine2, int zipCode, String city, String country, User user) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.user = user;
		
	}

	@Override
	public String toString() {
		return id + ", " + lastName + ", " + firstName + ", " + addressLine1 + ", " + addressLine2 + ", " + zipCode + ", " + city	+ ", " + country;
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
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}	
	
}
