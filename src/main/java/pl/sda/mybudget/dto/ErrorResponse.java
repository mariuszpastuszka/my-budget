package pl.sda.mybudget.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {
    LocalDateTime timestamp;
    int responseStatus;
    String message;
}
