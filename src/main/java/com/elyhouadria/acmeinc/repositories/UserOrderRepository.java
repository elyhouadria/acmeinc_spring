package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOrderRepository extends JpaRepository<UserOrder,Integer> {

    void deleteUserOrderById(Integer id);
    Optional<UserOrder> findUserOrderById(Integer id);

	/*int addUserOrder(UserOrder userOrder);

	List<UserOrder> getAllUserOrders();

	void deleteUserOrder(int userOrderId);

	void updateUserOrder(UserOrder userorder);
	
	public List<OrderLine> getUserOrderOrderlines(int userOrderId);
	
	public User findUserById(int userId);
	
	public Product findProductById(int productId);
	
	public Payment findPayementById(int payementId);
	
	public Shipping findShippingById(int shippingId);
	
	public Address findAdressById(int adressId);*/

}
