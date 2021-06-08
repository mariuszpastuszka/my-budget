package pl.sda.mybudget.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
    LocalDateTime timestamp,
    int responseStatus,
    String message) {
}
