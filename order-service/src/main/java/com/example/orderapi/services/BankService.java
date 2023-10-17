package com.example.orderapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BankService {

    private final WebClient webClient;

    public boolean consumeTransfer(Long customerCard, Long merchantCard, BigDecimal amount) {
        String url = "http://localhost:8080/home";
        return webClient.put()
                .uri(url + "/transfer", uriBuilder -> uriBuilder
                        .queryParam("customerCard", customerCard)
                        .queryParam("merchantCard", merchantCard)
                        .queryParam("amount", amount)
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
