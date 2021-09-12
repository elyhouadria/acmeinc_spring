package com.elyhouadria.acmeinc.controllers;


import com.elyhouadria.acmeinc.entities.Product;
import com.elyhouadria.acmeinc.services.ProductServices;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productServices.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Integer id) {
        Product product = productServices.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Product>> findProductByKeyword(@PathVariable("keyword") String keyword) {
        List<Product> products = productServices.findByKeyword(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/findbycategory/{id}")
    public ResponseEntity<List<Product>> findProductByCategoryId(@PathVariable("id") Integer id) {
        List<Product> products = productServices.findProductsByCategoryId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid
                                              @RequestBody Product product) {
        Product newProduct = productServices.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@Valid
                                                 @RequestBody Product product) {
        Product updateProduct = productServices.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable("id") Integer id) {
        productServices.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
