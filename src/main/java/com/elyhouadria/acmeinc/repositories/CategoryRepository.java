package com.elyhouadria.acmeinc.repositories;

import com.elyhouadria.acmeinc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

    void deleteCategoryById(Integer id);
    Optional<Category> findCategoryById(Integer id);
	
}
