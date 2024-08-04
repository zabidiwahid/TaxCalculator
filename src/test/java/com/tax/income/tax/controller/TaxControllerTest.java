package com.tax.income.tax.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tax.income.tax.model.Tax;
import com.tax.income.tax.services.TaxCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
public class TaxControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private TaxCalculator taxCalculator;

    @InjectMocks
    private TaxController taxController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @Tag("success")
    void testGetTax_Success() throws Exception {
        double annualIncome = 15000;
        
        when(taxCalculator.calculateTax(annualIncome));

        mockMvc.perform(get("/tax")
                .param("annualIncome", String.valueOf(annualIncome)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("100")))
                .andExpect(content().string(containsString("Category B: 1% on income above RM5,000")));
    }

    @Test
    @Tag("fail-no-param")
    void testGetTax_NoIncomeParam() throws Exception {
        mockMvc.perform(get("/tax"))
                .andExpect(status().isBadRequest());
    }
    
    // Additional tests for other scenarios, error cases, and edge cases can be added here
}
