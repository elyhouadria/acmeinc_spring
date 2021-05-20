package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.Category;
import com.elyhouadria.acmeinc.exceptions.CategoryNotFoundException;
import com.elyhouadria.acmeinc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category by id: " + id + " was not found"));
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategoryById(id);
    }


}
