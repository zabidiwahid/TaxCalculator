package com.tax.income.tax.services;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.tax.income.tax.model.Tax;

import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorTest {

    @Test
    @Tag("group-a")
    void calculateTax_NoTax() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 4000; // Below the taxable threshold

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(0, result.getTaxAmount());
        assertEquals("Category A: 0%", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().isEmpty());
    }

    @Test
    @Tag("group-b")
    void calculateTax_CategoryB() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 10000; // Falls in Category B

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(50, result.getTaxAmount());
        assertEquals("Category B: 1% on income above RM5,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-c")
    void calculateTax_CategoryC() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 30000; // Falls in Category C

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(500, result.getTaxAmount());
        assertEquals("Category C: 1% on income up to RM20,000, 3% on income above RM20,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-d")
    void calculateTax_CategoryD() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 45000; // Falls in Category D

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(1250, result.getTaxAmount());
        assertEquals("Category D: 1% on income up to RM35,000, 6% on income above RM35,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-e")
    void calculateTax_CategoryE() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 60000; // Falls in Category E

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(2950, result.getTaxAmount());
        assertEquals("Category E: 1% on income up to RM50,000, 11% on income above RM50,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-f")
    void calculateTax_CategoryF() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 90000; // Falls in Category F

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(8500, result.getTaxAmount());
        assertEquals("Category F: 1% on income up to RM70,000, 19% on income above RM70,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-g")
    void calculateTax_CategoryG() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 300000; // Falls in Category G

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(69500, result.getTaxAmount());
        assertEquals("Category G: 1% on income up to RM100,000, 25% on income above RM100,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-h")
    void calculateTax_CategoryH() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 500000; // Falls in Category H

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(134500, result.getTaxAmount());
        assertEquals("Category H: 1% on income up to RM400,000, 26% on income above RM400,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-i")
    void calculateTax_CategoryI() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 1500000; // Falls in Category I

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(363500, result.getTaxAmount());
        assertEquals("Category I: 1% on income up to RM600,000, 28% on income above RM600,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }

    @Test
    @Tag("group-j")
    void calculateTax_CategoryJ() {
        TaxCalculator taxCalculator = new TaxCalculator();
        double annualIncome = 2500000; // Falls in Category J

        Tax result = taxCalculator.calculateTax(annualIncome);

        assertEquals(783500, result.getTaxAmount());
        assertEquals("Category J: 1% on income up to RM2,000,000, 30% on income above RM2,000,000", result.getTaxSlab());
        assertTrue(result.getTaxClaimOptions().contains("Education fees (Self): Other than a degree at masters or doctorate level"));
    }
}

