package com.elyhouadria.acmeinc.entities;


import com.elyhouadria.acmeinc.entities.enums.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Address> userAddresses;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<UserOrder> userUserOrders;
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Review> userReviews;

	public User() {}

	public User(String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.userRole = userRole;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int id, String firstName, String lastName, String email, String password, Date creationDate, Boolean isActive, UserRole userRole) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.isActive = isActive;
		this.userRole = userRole;
	}

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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole role) {
		this.userRole = role;
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

	public List<Review> getUserReviews() {
		return userReviews;
	}

	public void setUserReviews(List<Review> userReviews) {
		this.userReviews = userReviews;
	}

	@Override
	public String toString() {
		return id + firstName + " " + lastName;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
