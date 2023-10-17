package com.fawryfinalproject.productapi.model;


import lombok.Data;

@Data
public class ProductStoreModel {

    private Long id;

    private String name;

    private double price;

    private String categoryName;

    private String imageUrl;

//    @JsonIgnore
//    private CategoryEntity category;
}
