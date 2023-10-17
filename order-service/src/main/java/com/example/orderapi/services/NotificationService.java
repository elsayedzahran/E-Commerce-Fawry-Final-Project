package com.example.orderapi.services;

import com.example.orderapi.dtos.EmailDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotificationService {
    String url = "http://localhost:8082/emails";
    WebClient.Builder builder = WebClient.builder();

    public void sendEmail(EmailDto emailDto) {
        builder.build()
                .post()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
