package com.elyhouadria.acmeinc.controllers;


import com.elyhouadria.acmeinc.entities.Category;
import com.elyhouadria.acmeinc.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryServices.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = categoryServices.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@Valid
                                                @RequestBody Category category) {
        Category newCategory = categoryServices.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@Valid
                                                   @RequestBody Category category) {
        Category updateCategory = categoryServices.updateCategory(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        categoryServices.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
