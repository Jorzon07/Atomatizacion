package com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public org.springframework.http.ResponseEntity<Map<String, Object>> handleArithmeticException(ArithmeticException ex) {
        return org.springframework.http.ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "error", "Operación inválida",
                        "mensaje", ex.getMessage()
                ));
    }
}