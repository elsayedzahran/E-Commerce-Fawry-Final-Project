package com.example.orderapi.repositories;

import com.example.orderapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
