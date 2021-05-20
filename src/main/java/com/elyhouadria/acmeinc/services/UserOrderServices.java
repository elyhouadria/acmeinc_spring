package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.UserOrder;
import com.elyhouadria.acmeinc.exceptions.UserOrderNotFoundException;
import com.elyhouadria.acmeinc.repositories.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServices {

    private final UserOrderRepository userOrderRepository;

    @Autowired
    public UserOrderServices(UserOrderRepository userOrderRepository) {
        this.userOrderRepository = userOrderRepository;
    }

    public UserOrder addUserOrder(UserOrder userOrder) {
        return userOrderRepository.save(userOrder);
    }

    public List<UserOrder> findAllUserOrders() {
        return userOrderRepository.findAll();
    }

    public UserOrder updateUserOrder(UserOrder userOrder) {
        return userOrderRepository.save(userOrder);
    }

    public UserOrder findUserOrderById(Integer id) {
        return userOrderRepository.findUserOrderById(id)
                .orElseThrow(() -> new UserOrderNotFoundException("UserOrder by id: " + id + " was not found"));
    }

    public void deleteUserOrderById(Integer id) {
        userOrderRepository.deleteUserOrderById(id);
    }

}
