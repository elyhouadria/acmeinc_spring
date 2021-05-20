package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.Product;
import com.elyhouadria.acmeinc.exceptions.ProductNotFoundException;
import com.elyhouadria.acmeinc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Integer id) {
        return productRepository.findPaymentById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id: " + id + " was not found"));
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }

}
