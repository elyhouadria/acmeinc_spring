package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.Address;
import com.elyhouadria.acmeinc.exceptions.AddressNotFoundException;
import com.elyhouadria.acmeinc.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServices {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServices(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }
    public List<Address> findAllAddresses(){
        return addressRepository.findAll();
    }
    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }

    public Address findAddressById(Integer id){
        return addressRepository.findAddressById(id)
                .orElseThrow(()->new AddressNotFoundException("Address by id: " + id + " was not found"));
    }
    public Address[] findAddressesByUserId(Integer id) {
        return addressRepository.findAddressesByAcmeUser_Id(id)
                .orElseThrow(() -> new AddressNotFoundException("Addresses by user id: " + id + " was not found"));
    }
    @Transactional
    public void deleteAddress(Integer id) {
        addressRepository.deleteAddressById(id);
    }

}
