package com.example.orderapi.services;

import com.example.orderapi.dtos.PostProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final WebClient webClient;
    private final String url = "http://localhost:8084/api/warehouses";
    public List<PostProductDto> validateProductsInStore(Map<Integer, Integer> productsList, long warId){
        return webClient.post()
                .uri(url + "/{warId}/check/product", warId)
                .bodyValue(productsList)
                .retrieve()
                .bodyToFlux(PostProductDto.class)
                .collectList()
                .block();
    }
    public boolean consumeProductsFomWarehouse(Map<Integer, Integer> productsList, long warId){
        Map<Integer, Integer> test = new HashMap<>();
        test.put(1,3);
        test.put(2,3);
        return Boolean.TRUE.equals(webClient.post()
                .uri(url + "/{warId}/products/consume", warId)
                .bodyValue(productsList)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}
