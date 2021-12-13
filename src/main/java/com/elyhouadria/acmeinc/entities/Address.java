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
	@Pattern(regexp = "^[0-9a-zA-Z- ]{5,17}$",
			message = "Please enter a valid Zip Code")
	private String zipCode;
	@Column(length = 35)
	@Pattern(regexp = "^[a-zA-Z-àáâãäåçèéêëìíîïðòóôõöùúûüýÿ' ]{2,35}$",
			message = "Please enter a valid City")
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

}
