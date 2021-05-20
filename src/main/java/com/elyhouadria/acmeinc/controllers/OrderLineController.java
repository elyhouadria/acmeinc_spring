package com.elyhouadria.acmeinc.controllers;

import com.elyhouadria.acmeinc.entities.OrderLine;
import com.elyhouadria.acmeinc.services.OrderLineServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orderline")
public class OrderLineController {

    private final OrderLineServices orderLineServices;

    public OrderLineController(OrderLineServices orderLineServices){this.orderLineServices=orderLineServices;}

    @GetMapping("/all")
    public ResponseEntity<List<OrderLine>> getAllOrderLines(){
        List<OrderLine> orderLines = orderLineServices.findAllOrderLines();
        return new ResponseEntity<>(orderLines, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<OrderLine> getAllOrderLine(@PathVariable("id") Integer id){
        OrderLine orderLine = orderLineServices.findOrderLineById(id);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderLine> addOrderLine(@RequestBody OrderLine orderLine){
        orderLine.setOrderLineDate(new Date());
        OrderLine newOrderLine = orderLineServices.addOrderLine(orderLine);
        return new ResponseEntity<>(newOrderLine, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderLine> updateOrderLine(@RequestBody OrderLine orderLine){
        OrderLine updateOrderLine = orderLineServices.updateOrderLine(orderLine);
        return new ResponseEntity<>(updateOrderLine, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderLine(@PathVariable("id") Integer id){
        orderLineServices.deleteOrderLineById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
