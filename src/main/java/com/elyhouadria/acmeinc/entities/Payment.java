package com.elyhouadria.acmeinc.entities;
import com.elyhouadria.acmeinc.entities.enums.PayementStatus;
import com.elyhouadria.acmeinc.entities.enums.PayementType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Data
public class Payment implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(length= 11)
	@NotNull
	private Double amount;

	@Column(length= 35)
	@Pattern(regexp = "^[a-zA-Zàáâãäåçèéêëìíîïðòóôõöùúûüýÿ ]{2,35}$",
			message = "Please enter a valid currency name.")
	private String currency;
	
	@Enumerated(EnumType.STRING)
	@Column(length= 32)
	private PayementStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(length= 32)
	private PayementType paymentType;

	@JsonBackReference(value = "user_order_payment")
	@OneToOne(mappedBy="payment")
	private UserOrder userorder;

}
