package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOrderRepository extends JpaRepository<UserOrder,Integer> {

    void deleteUserOrderById(Integer id);
    Optional<UserOrder> findUserOrderById(Integer id);

}
