package com.example.orderapi.resources;


import com.example.orderapi.dtos.CouponResponseDto;
import com.example.orderapi.dtos.OrderRequestDto;
import com.example.orderapi.services.BankService;
import com.example.orderapi.services.CouponService;
import com.example.orderapi.services.OrderService;
import com.example.orderapi.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private BankService bankService;

    @PostMapping
    public String placeOrder(OrderRequestDto orderRequestDto) {
        orderService.createOrder(orderRequestDto, "null", "null", 1);
        return "success";
    }

    @GetMapping("get/{code}")
    public CouponResponseDto testCouponRequest(@PathVariable String code) {
        return couponService.validateCoupon(code);
    }

    @GetMapping
    public boolean testCouponRequest(@RequestParam long customerCard, @RequestParam long merchantCard, @RequestParam BigDecimal amount) {
        return bankService.consumeTransfer(customerCard, merchantCard, amount);
    }
}
