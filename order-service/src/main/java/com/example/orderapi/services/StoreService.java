package com.example.orderapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final WebClient webClient;

    public boolean validateProductsInStore(List<Integer> productsList) {
        String url = "";
        return Boolean.TRUE.equals(
                webClient.get()
                .uri(url, uriBuilder ->
                        uriBuilder.queryParam("productsId", productsList).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}
