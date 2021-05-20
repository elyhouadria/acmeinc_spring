package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.Address;
import com.elyhouadria.acmeinc.services.AddressServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private  final AddressServices addressServices;

    public AddressController (AddressServices addressServices){this.addressServices = addressServices;}


    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllSortedById(){
        List<Address> addresses = addressServices.findAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id){
        Address address = addressServices.findAddressById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        Address newAddress = addressServices.addAddress(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        Address updateAddress = addressServices.updateAddress(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Integer id){
        addressServices.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}