package com.example.orderapi.mapper;

import com.example.orderapi.dtos.OrderItemsDto;
import com.example.orderapi.entities.OrderItem;

public interface Mapper {
    OrderItem mapToOrderItemEntity(OrderItemsDto orderItemsDto);
}
