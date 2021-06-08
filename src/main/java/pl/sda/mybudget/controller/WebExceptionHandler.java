package pl.sda.mybudget.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(Exception.class)
    String handleException(Model model, Exception exception) {
        model.addAttribute("errorDescription", exception.getMessage());

        return "error-page";
    }
}
