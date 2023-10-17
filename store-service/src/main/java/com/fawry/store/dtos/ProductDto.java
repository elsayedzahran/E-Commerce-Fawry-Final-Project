package com.fawry.store.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    long id;

    String name;

    double price;


    String categoryName;
}
