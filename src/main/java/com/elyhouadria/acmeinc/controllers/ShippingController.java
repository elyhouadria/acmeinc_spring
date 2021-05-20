package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.Shipping;
import com.elyhouadria.acmeinc.services.ShippingServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingServices shippingServices;

    public ShippingController(ShippingServices shippingServices){this.shippingServices=shippingServices;}

    @GetMapping("/all")
    public ResponseEntity<List<Shipping>> getAllShippings(){
        List<Shipping> shippings = shippingServices.findAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Shipping> findShippingById(@PathVariable("id") Integer id){
        Shipping shipping = shippingServices.findShippingById(id);
        return new ResponseEntity<>(shipping, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Shipping> addShipping(@RequestBody Shipping shipping){
        Shipping newShipping = shippingServices.addShipping(shipping);
        return new ResponseEntity<>(newShipping, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Shipping> updateShipping(@RequestBody Shipping shipping){
        Shipping updateShipping = shippingServices.updateShipping(shipping);
        return new ResponseEntity<>(updateShipping, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShipping(@PathVariable("id") Integer id){
        shippingServices.deleteShippingById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
