package com.fawryfinalproject.productapi.controller;

import com.fawryfinalproject.productapi.model.CategoryModel;
import com.fawryfinalproject.productapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //-------------------------------------------------------------------------------------------//

    @GetMapping()
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //-------------------------------------------------------------------------------------------//

    @PostMapping(path = "/saveNewCategory")
    public void createNewProduct(@RequestBody CategoryModel categoryModel) {
        categoryService.createNewCategory(categoryModel);
    }

    //-------------------------------------------------------------------------------------------//

    @DeleteMapping(value = "/deleteProduct/{name}")
    public void deleteProductById(@PathVariable String name) {
        categoryService.deleteCategory(name);
    }
}
