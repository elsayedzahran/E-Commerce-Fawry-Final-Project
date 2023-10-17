package com.fawryfinalproject.productapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fawryfinalproject.productapi.entity.CategoryEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductModel {
    @NotNull
    private Long id;
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    @Min(value = 1, message = "Product price cannot be 0")
    private double price;
    @Min(value = 1, message = "Category ID must be a positive number")
    private int categoryId;
    @NotBlank(message = "Image link cannot be blank")
    private String imageUrl;
    //    @NotBlank(message = "Category name cannot be blank")
    private String categoryName;
    @JsonIgnore
    private CategoryEntity category;

    public ProductModel(Long id, String name, double price, String imageUrl, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public ProductModel() {
    }
}
