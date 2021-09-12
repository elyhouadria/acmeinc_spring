package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductPaginationRepository extends PagingAndSortingRepository<Product, Integer> {

}
