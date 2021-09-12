package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findAddressById(Integer id);
    void deleteAddressById(Integer id);
    Optional<Address[]> findAddressesByAcmeUser_Id(Integer id);

}
