package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    void deleteOrderLineById(Integer id);
    Optional<OrderLine> findOrderLineById(Integer id);
    Optional<OrderLine[]> findOrderLinesByUserOrderId(Integer id);

}
