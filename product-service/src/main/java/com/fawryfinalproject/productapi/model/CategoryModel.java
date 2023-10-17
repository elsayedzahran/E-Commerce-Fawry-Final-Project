package com.fawryfinalproject.productapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryModel {
    private int categoryId;
    @NotBlank(message = "Category name cannot be blank")
    @JsonProperty("CategoryName")
    private String name;

    public CategoryModel() {
    }

    public CategoryModel(String name) {
        this.name = name;
    }


}
