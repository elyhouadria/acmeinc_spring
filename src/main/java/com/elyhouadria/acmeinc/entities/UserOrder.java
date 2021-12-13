package com.elyhouadria.acmeinc.entities;
import com.elyhouadria.acmeinc.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class UserOrder implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length= 11)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length= 32)
	private OrderStatus orderStatus;

	@Column(length= 11)
	@DecimalMin("1.0")
	@DecimalMin("1.0")
	private Double totalPrice;


	@ManyToOne
	@JoinColumn(name="fk_userid")
	private AcmeUser acmeUser;

	@ManyToOne
	@JoinColumn(name="fk_shippingaddressid")
	private Address shippingAddress;

	@ManyToOne
	@JoinColumn(name="fk_billingaddressid")
	private Address billingAddress;

	@JsonManagedReference(value = "user_order_orderLine")
	@OneToMany(mappedBy= "userOrder")
	private List<OrderLine> productOrderList;

	@ManyToOne
	@JoinColumn(name="fk_shippingid")
	private Shipping shipping;

	@JsonManagedReference(value = "user_order_payment")
	@OneToOne
	@JoinColumn(name="fk_payementid")
	private Payment payment;

}
