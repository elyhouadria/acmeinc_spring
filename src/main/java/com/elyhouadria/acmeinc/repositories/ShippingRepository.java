package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {


    void deleteShippingById(Integer id);
    Optional<Shipping> findShippingById(Integer id);


	/*int addShipping(Shipping shipping);

	void updateShipping(Shipping shipping);
	
	public void deleteShipping(int shippingId);
	
	public List<Shipping> getAllShippings();*/

}
