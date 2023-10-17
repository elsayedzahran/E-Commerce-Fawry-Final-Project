package com.example.orderapi.services;

import com.example.orderapi.dtos.OrderRequestDto;
import com.example.orderapi.entities.Order;
import com.example.orderapi.entities.OrderItem;
import com.example.orderapi.repositories.OrderItemRepo;
import com.example.orderapi.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderItemRepo orderItemsRepo;
    @Autowired
    private OrderRepo orderRepo;
    //    @Autowired
//    private WebClient webClient;
    @Autowired
    private StoreService storeService;
    @Autowired
    private Mapper mapper;

    @Override
    public void createOrder(OrderRequestDto orderRequestDto, String email, String accountNumber, int storeId) {

        Order order = new Order();

        List<OrderItem> orderItems = orderRequestDto.getOrderItemsDtos()
                .stream()
                .map(orderItemsDto -> mapper.mapToOrderItemEntity(orderItemsDto))
                .toList();
        order.setOrderItems(orderItems);
        order.setEmail("test@test.com");
        order.setCopoun("sasasa");
        order.setStoreId(1);

        List<Integer> productIds = orderItems.stream()
                .map(orderItem -> orderItem.getProductId())
                .toList();
        boolean ok = storeService.validateProductsInStore(productIds);

        Order save = orderRepo.save(order);

        // validate order items

        //git cost

        //withdraw money from bankApi

        //deposit money from bankApi

        //send notification
    }

    @Override
    public void createOrderWithCopoun(OrderRequestDto order, String email, String accountNumber, int storeId) {
        // validate order items

        //git cost

        //validate and consume coupon

        //withdraw money from bankApi

        //deposit money from bankApi

        //send notification
    }
}
