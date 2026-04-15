package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/sumar")
    public Map<String, Object> sumar(@RequestParam double a, @RequestParam double b) {
        return Map.of(
                "operacion8", "sumar",
                "a", a,
                "b", b,
                "resultado", calculatorService.sumar(a, b)
        );
    }

    @GetMapping("/restar")
    public Map<String, Object> restar(@RequestParam double a, @RequestParam double b) {
        return Map.of(
                "operacion8", "restar",
                "a", a,
                "b", b,
                "resultado", calculatorService.restar(a, b)
        );
    }

    @GetMapping("/multiplicar")
    public Map<String, Object> multiplicar(@RequestParam double a, @RequestParam double b) {
        return Map.of(
                "operacion8", "multiplicar",
                "a", a,
                "b", b,
                "resultado", calculatorService.multiplicar(a, b)
        );
    }

    @GetMapping("/dividir")
    public Map<String, Object> dividir(@RequestParam double a, @RequestParam double b) {
        return Map.of(
                "operacion8", "dividir",
                "a", a,
                "b", b,
                "resultado", calculatorService.dividir(a, b)
        );
    }
}