package com.elyhouadria.acmeinc.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class AcmeUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length= 36)
	private int id;
	@Column(length = 26)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,26}$",
			message = "Invalid first name.")
	private String firstName;
	@Column(length = 26)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,26}$",
			message = "Invalid last name.")
	private String lastName;

	@Column(length = 254)
	@Email(message = "Email invalid")
	private String email;

	@Column(length = 254, nullable = false)
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{6,254}$",
			message = "Password invalid")
	private String password;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(length = 52)
	private String roles;

	@JsonManagedReference(value="user_address")
	@OneToMany(mappedBy="acmeUser", cascade = CascadeType.ALL)
	private List<Address> userAddresses;

	//JsonIgnore to prevent JSON circular problems
	@JsonIgnore
	@OneToMany(mappedBy="acmeUser", cascade = CascadeType.ALL)
	private List<UserOrder> userUserOrders;

}
