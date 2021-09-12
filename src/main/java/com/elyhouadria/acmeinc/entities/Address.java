package com.elyhouadria.acmeinc.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Address implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length= 36)
	private int id;
	@Column(length = 26)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,26}$",
			message = "Please enter a valid first name.")
	private String lastName;
	@Column(length = 26)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,26}$",
			message = "Please enter a valid last name.")
	private String firstName;

	@Column(length = 45)
	@Pattern(regexp = "^[0-9a-zA-Z-'àáâãäåçèéêëìíîïðòóôõöùúûüýÿ' ]{5,45}$",
			message = "Please enter a valid address line 1")
	private String addressLine1;
	@Column(length = 45)
	@Pattern(regexp = "^[0-9a-zA-Z-'àáâãäåçèéêëìíîïðòóôõöùúûüýÿ' ]{2,45}$",
			message = "Please enter a valid address line 2")
	private String addressLine2;
	@Column(length = 17)
	@Pattern(regexp = "^[0-9a-zA-Z- ]{5,17}$")
	private int zipCode;
	@Column(length = 35)
	@Pattern(regexp = "^[a-zA-Z-àáâãäåçèéêëìíîïðòóôõöùúûüýÿ' ]{2,35}$",
			message = "Please enter a valid Zip Code.")
	private String city;
	@Column(length = 50)
	@Pattern(regexp = "^[a-zA-Z-àáâãäåçèéêëìíîïðòóôõöùúûüýÿ' ]{2,50}$")
	private String country;

	@JsonBackReference(value="user_address")
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private AcmeUser acmeUser;

	@JsonIgnore
	@OneToMany(mappedBy= "shippingAddress")
	private List<UserOrder> shippingAddress;

	@JsonIgnore
	@OneToMany(mappedBy= "billingAddress")
	private List<UserOrder> billingAddress;



	/*public Address() {}

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
	
	public AcmeUser getUser() {
		return acmeUser;
	}

	public void setUser(AcmeUser acmeUser) {
		this.acmeUser = acmeUser;
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

	public Address(String lastName, String firstName, String addressLine1, String addressLine2, int zipCode, String city, String country, AcmeUser acmeUser) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.acmeUser = acmeUser;
		}

	public Address(int id, String lastName, String firstName, String addressLine1, String addressLine2, int zipCode, String city, String country, AcmeUser acmeUser) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.acmeUser = acmeUser;
		
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
	*/
}
