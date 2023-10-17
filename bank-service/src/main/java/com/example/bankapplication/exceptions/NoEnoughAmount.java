package com.example.bankapplication.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NoEnoughAmount extends RuntimeException {

    public NoEnoughAmount(String message) {
        super(message);
    }

}
