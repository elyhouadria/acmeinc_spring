package com.elyhouadria.acmeinc.entities;



import com.elyhouadria.acmeinc.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity

public class UserOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Temporal(TemporalType.DATE)
	private Date shippingDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="fk_userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="fk_shippingaddressid")
	private Address shippingAddress;

	@ManyToOne
	@JoinColumn(name="fk_billingaddressid")
	private Address billingAddress;

	
	@OneToMany(mappedBy="userorder")
	private List<OrderLine> productOrderList;
	
	
	//need to change this it's a many to one
	@OneToOne
	@JoinColumn(name="fk_shippingid")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="fk_payementid")
	private Payment payment;
	

	public UserOrder() {}
	
	public UserOrder(Date orderDate,Date shippingDate,OrderStatus orderStatus,Double totalPrice, Shipping shipping) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.shipping = shipping;
	}
	
	public UserOrder(Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, 	Address shippingAddress) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.shippingAddress = shippingAddress;
	}

	public UserOrder(Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, Address shippingAddress, Shipping shipping, Payment payment) {
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.shipping = shipping;
		this.payment = payment;
	}
	
	public UserOrder(int id, Date orderDate, Date shippingDate, OrderStatus orderStatus, Double totalPrice, User user, Address shippingAddress, Shipping shipping, Payment payment) {
		this.id = id;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.orderStatus = orderStatus;
		this.totalPrice = totalPrice;
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.shipping = shipping;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void seOrderStatus(OrderStatus orderstatus) {
		this.orderStatus = orderstatus;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address address) {
		this.shippingAddress = address;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public List<OrderLine> getProductOrderList() {
		return productOrderList;
	}

	public void setProductOrderList(List<OrderLine> productOrderList) {
		this.productOrderList = productOrderList;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return id + " order date: " + orderDate + ", " + orderStatus + ", " + totalPrice;
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
		UserOrder other = (UserOrder) obj;
		if (id != other.id)
			return false;
		return true;
	}




}