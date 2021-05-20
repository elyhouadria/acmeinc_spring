package com.elyhouadria.acmeinc.services;


import com.elyhouadria.acmeinc.entities.Shipping;
import com.elyhouadria.acmeinc.exceptions.ShippingNotFoundException;
import com.elyhouadria.acmeinc.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServices {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingServices(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Shipping addShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public List<Shipping> findAllShippings() {
        return shippingRepository.findAll();
    }

    public Shipping updateShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Shipping findShippingById(Integer id) {
        return shippingRepository.findShippingById(id)
                .orElseThrow(() -> new ShippingNotFoundException("Shipping by id: " + id + " was not found"));
    }

    public void deleteShippingById(Integer id) {
        shippingRepository.deleteShippingById(id);
    }

}
