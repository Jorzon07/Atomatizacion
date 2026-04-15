package com.example.calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testSumar() {
        double resultado = calculatorService.sumar(10, 5);
        assertEquals(15.0, resultado);
    }

    @Test
    void testRestar() {
        double resultado = calculatorService.restar(10, 5);
        assertEquals(5.0, resultado);
    }

    @Test
    void testMultiplicar() {
        double resultado = calculatorService.multiplicar(10, 5);
        assertEquals(50.0, resultado);
    }

    @Test
    void testDividir() {
        double resultado = calculatorService.dividir(10, 5);
        assertEquals(2.0, resultado);
    }

    @Test
    void testDividirPorCero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculatorService.dividir(10, 0)
        );

        assertEquals("No se puede dividir entre cero", exception.getMessage());
    }
}
