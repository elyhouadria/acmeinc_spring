package com.elyhouadria.acmeinc.controllers;
import com.elyhouadria.acmeinc.entities.Product;
import com.elyhouadria.acmeinc.repositories.ProductPaginationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/productpagination")
public class ProductPaginationController {

    private final ProductPaginationRepository productPaginationRepository;

    @Autowired
    public ProductPaginationController(ProductPaginationRepository productPaginationRepository) {
        this.productPaginationRepository = productPaginationRepository;
    }

    @GetMapping
    public Page<Product> getPagination(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "12") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> pageResult = productPaginationRepository.findAll(pageRequest);
        List<Product> products = pageResult.toList();
        return new PageImpl<>(products, pageRequest, pageResult.getTotalElements());

    }
}
