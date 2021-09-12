package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductById(Integer id);
    void deleteProductById(Integer id);
    List<Product> getProductsByCategory_Id(Integer id);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1%" + "OR p.productDescription LIKE %?1%")
    List<Product> findAll(String keyword);

}
