package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    void deleteEmployeeById(Integer id);
    Optional<Address> findAdressById(Integer id);

/*
	int addAdress(Address adress);

	void deleteAdress(int adressId);

	void updateAdress(Address adress);

	List<Address> getAllAdresses();
	
	public User findUserById(int userId);
*/

}
