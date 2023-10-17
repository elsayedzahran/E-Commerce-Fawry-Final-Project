package com.example.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {

    @JsonProperty("Transaction ID")
    private Long id;
    @JsonProperty("Card Number")
    private Long cardNumber;
    @JsonProperty("Timestamp")
    private LocalDate timestamp;
    @JsonProperty("Transaction Type")
    private String type;
    @JsonProperty("Amount")
    private BigDecimal amount;
}
