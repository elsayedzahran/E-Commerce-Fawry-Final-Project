package com.example.orderapi.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private String productName;
    private double price;
    private int quantity;
}
