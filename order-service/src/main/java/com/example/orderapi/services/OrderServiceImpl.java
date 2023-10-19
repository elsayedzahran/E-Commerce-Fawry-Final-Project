package com.example.orderapi.services;

import com.example.orderapi.dtos.OrderRequestDto;
import com.example.orderapi.entities.Order;
import com.example.orderapi.entities.OrderItem;
import com.example.orderapi.mapper.Mapper;
import com.example.orderapi.repositories.OrderItemRepo;
import com.example.orderapi.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderItemRepo orderItemsRepo;
    private final OrderRepo orderRepo;
    private final StoreService storeService;
    private final Mapper mapper;
    private final WebClient webClient;

    @Override
    public void createOrder(OrderRequestDto orderRequestDto, String email, String accountNumber, int storeId) {

        Order order = new Order();

        List<OrderItem> orderItems = orderRequestDto.getOrderItemsDtos()
                .stream()
                .map(mapper::mapToOrderItemEntity)
                .toList();
        order.setOrderItems(orderItems);
        order.setEmail("test@test.com");
        order.setCoupon("sasasa");
        order.setStoreId(1);

        List<Integer> productIds = orderItems.stream()
                .map(OrderItem::getProductId)
                .toList();

        Order save = orderRepo.save(order);

        // validate order items

        //git cost

        //withdraw money from bankApi

        //deposit money from bankApi

        //send notification
    }




    @Override
    public void createOrderWithCoupon(OrderRequestDto order, String email, String accountNumber, int storeId) {
        // validate order items

        //git cost

        //validate and consume coupon

        //withdraw money from bankApi

        //deposit money from bankApi

        //send notification
    }
}
