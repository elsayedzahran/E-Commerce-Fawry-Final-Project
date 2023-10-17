package com.example.couponapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsumptionDTO {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long couponId;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("consumption_timestamp")
    private LocalDateTime dateTime;

    // For visible output
    @JsonProperty("consumption_id")
    public Long getId() {
        return id;
    }
}
