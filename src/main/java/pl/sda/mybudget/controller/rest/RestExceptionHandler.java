package pl.sda.mybudget.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.mybudget.dto.ErrorResponse;
import pl.sda.mybudget.exception.ReplaceIncomeException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ReplaceIncomeException.class, NoSuchElementException.class})
    ErrorResponse handleException(Exception exception) {
        return new ErrorResponse(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage());
    }
}
