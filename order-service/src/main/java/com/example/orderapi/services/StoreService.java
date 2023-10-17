package com.example.orderapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StoreService {
    private final String url = "";
    @Autowired
    private WebClient webClient;

    public boolean validateProductsInStore(List<Integer> productsList) {
        return webClient.get()
                .uri(url,
                        uriBuilder -> uriBuilder.queryParam("productsId", productsList).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
