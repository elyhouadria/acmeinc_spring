package com.elyhouadria.acmeinc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
public class OrderLine implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length= 36)
	private int id;
	@Column(length= 3)
	//@Pattern(regexp = "^[0-9]{1,3}$")
	@NotNull
	private int quantity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderLineDate;

	@ManyToOne
	@JoinColumn(name="fk_productid")
	private Product product;

	@JsonBackReference(value = "user_order_orderLine")
	@ManyToOne
	@JoinColumn(name="fk_userorderid")
	private UserOrder userOrder;

	@Column(length= 11)
	//@Pattern(regexp = "^\\d+(,\\d{1,2})?$")
	@NotNull
	private double orderLinePrice;

	public OrderLine() {}

}
