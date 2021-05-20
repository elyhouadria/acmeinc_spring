package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.Category;
import com.elyhouadria.acmeinc.entities.OrderLine;
import com.elyhouadria.acmeinc.exceptions.OrderLineNotFoundException;
import com.elyhouadria.acmeinc.repositories.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineServices {

    private final OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineServices(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public OrderLine addOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> findAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public OrderLine updateOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public OrderLine findOrderLineById(Integer id) {
        return orderLineRepository.findOrderLineById(id)
                .orElseThrow(() -> new OrderLineNotFoundException("OrderLine by id: " + id + " was not found"));
    }

    public void deleteOrderLineById(Integer id) {
        orderLineRepository.deleteOrderLineById(id);
    }

}
