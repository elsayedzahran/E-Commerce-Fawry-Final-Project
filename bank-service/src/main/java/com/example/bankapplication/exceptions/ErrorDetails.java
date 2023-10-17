package com.example.bankapplication.exceptions;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@RequiredArgsConstructor
public class ErrorDetails {
    private final String message;
    private final String code;
    private String dateTime = LocalDateTime.now()
            .format(DateTimeFormatter.ISO_DATE_TIME);
}
