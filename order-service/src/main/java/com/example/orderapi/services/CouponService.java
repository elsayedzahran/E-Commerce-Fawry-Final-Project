package com.example.orderapi.services;

import com.example.orderapi.dtos.CouponResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final WebClient webClient;
    private final String url = "http://localhost:8081/coupon";

    public CouponResponseDto getCoupon(String code) {
        return webClient.get()
                .uri(url + "/find", uriBuilder -> uriBuilder.queryParam("code", code).build())
                .retrieve()
//                .onStatus(HttpStatusCode::isError, clientResponse -> Mono.error(new Throwable("invalid couponId")))
                .bodyToMono(CouponResponseDto.class)
                .block();
    }


    public boolean consumeCoupon(String code, int orderId) {
        return Boolean.TRUE.equals(
                webClient.put()
                .uri(url + "/consume", uriBuilder -> uriBuilder
                        .queryParam("code", code)
                        .queryParam("orderId", orderId)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> Mono.error(new Throwable("invalid couponCode")))
                .bodyToMono(Boolean.class)
                .block());
    }
}
