package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductById(Integer Id);
    void deleteProductById(Integer id);
}
