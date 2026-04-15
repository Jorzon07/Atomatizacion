package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
@Import(CalculatorService.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Debe sumar correctamente")
    void testSumarEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/sumar")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operacion").value("sumar"))
                .andExpect(jsonPath("$.a").value(10.0))
                .andExpect(jsonPath("$.b").value(5.0))
                .andExpect(jsonPath("$.resultado").value(15.0));
    }

    @Test
    @DisplayName("Debe restar correctamente")
    void testRestarEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/restar")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operacion").value("restar"))
                .andExpect(jsonPath("$.resultado").value(5.0));
    }

    @Test
    @DisplayName("Debe multiplicar correctamente")
    void testMultiplicarEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/multiplicar")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operacion").value("multiplicar"))
                .andExpect(jsonPath("$.resultado").value(50.0));
    }

    @Test
    @DisplayName("Debe dividir correctamente")
    void testDividirEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/dividir")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operacion").value("dividir"))
                .andExpect(jsonPath("$.resultado").value(2.0));
    }

    @Test
    @DisplayName("Debe responder error al dividir por cero")
    void testDividirPorCeroEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/dividir")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Operación inválida"))
                .andExpect(jsonPath("$.mensaje").value("No se puede dividir entre cero"));
    }
}
