package com.example.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRequest {

    @NotNull(message = "Card number code cannot be null")
    @Range(min = 1000000000000000L, max = 9999999999999999L, message = "Card number must be 16 numbers long")
    @JsonProperty("Card Number")
    private Long cardNumber;

    @NotBlank(message = "Username cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Username shall include alphabetical characters only")
    @JsonProperty("Username")
    private String username;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 8, message = "Password should include at least 8 characters")
    @JsonProperty("Password")
    private String password;

    @PositiveOrZero(message = "Balance cannot be negative")
    @JsonIgnore
    private BigInteger balance;

}