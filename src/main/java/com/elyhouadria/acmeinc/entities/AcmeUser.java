package com.elyhouadria.acmeinc.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class AcmeUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	private Boolean isActive;

	private String roles;
	
	@OneToMany(mappedBy="acmeUser", cascade = CascadeType.ALL)
	private List<Address> userAddresses;
	
	@OneToMany(mappedBy="acmeUser", cascade = CascadeType.ALL)
	private List<UserOrder> userUserOrders;


	/*public AcmeUser(String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, String roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.roles = roles;
	}

	public AcmeUser(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public AcmeUser(int id, String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, String roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.roles = roles;
	}

	public AcmeUser() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Address> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(List<Address> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public List<UserOrder> getuserUserOrders() {
		return userUserOrders;
	}

	public void setUserOrders(List<UserOrder> userUserOrders) {
		this.userUserOrders = userUserOrders;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return id + firstName + " " + lastName;
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
		AcmeUser other = (AcmeUser) obj;
		if (id != other.id)
			return false;
		return true;
	}
	*/
}
