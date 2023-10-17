package com.example.orderapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@Service
public class BankService {
    String url = "http://localhost:8083/home";
    @Autowired
    private WebClient webClient;

    public boolean consumeTransfer(long customerCard, long merchantCard, BigDecimal amount) {
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
