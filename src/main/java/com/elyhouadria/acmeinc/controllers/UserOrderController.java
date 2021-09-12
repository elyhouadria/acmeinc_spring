package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.UserOrder;
import com.elyhouadria.acmeinc.services.UserOrderServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userorder")
public class UserOrderController {

    private final UserOrderServices userOrderServices;

    public UserOrderController(UserOrderServices userOrderServices) {
        this.userOrderServices = userOrderServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserOrder>> getAllUserOrders() {
        List<UserOrder> userOrders = userOrderServices.findAllUserOrders();
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserOrder> findUserOrderById(@PathVariable("id") Integer id) {
        UserOrder userOrder = userOrderServices.findUserOrderById(id);
        return new ResponseEntity<>(userOrder, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserOrder> addUserOrder(@Valid
                                                  @RequestBody UserOrder userOrder) {
        userOrder.setOrderDate(new Date());
        UserOrder newUserOrder = userOrderServices.addUserOrder(userOrder);
        return new ResponseEntity<>(newUserOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserOrder> updateUserOrder(@Valid
                                                     @RequestBody UserOrder userOrder) {
        UserOrder updateUserOrder = userOrderServices.updateUserOrder(userOrder);
        return new ResponseEntity<>(updateUserOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserOrder(@PathVariable("id") Integer id) {
        userOrderServices.deleteUserOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
