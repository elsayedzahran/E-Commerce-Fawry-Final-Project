package com.example.orderapi.services;

import com.example.orderapi.dtos.OrderRequestDto;

public interface OrderService {
    void createOrder(OrderRequestDto order, String email, String AccountNumber, int storeId);

    void createOrderWithCopoun(OrderRequestDto order, String email, String AccountNumber, int storeId);
}
