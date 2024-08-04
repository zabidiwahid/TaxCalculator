package com.tax.income.tax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tax.income.tax.model.Tax;
import com.tax.income.tax.services.TaxCalculator;

@RestController
@RequestMapping("/") 
public class TaxController {

    private TaxCalculator taxCalculator;

    @Autowired
    public void setTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @RequestMapping(value = "/tax", method = RequestMethod.GET)
    public ResponseEntity<?> getTax(@RequestParam(required = false) Double annualIncome) {
        if (annualIncome == null) {
            // Return a 400 Bad Request with a custom message
            return new ResponseEntity<>("Missing annualIncome parameter", HttpStatus.BAD_REQUEST);
        }
        
        try {
            Tax tax = taxCalculator.calculateTax(annualIncome);
            // Return a 200 OK with the tax data
            return new ResponseEntity<>(tax, HttpStatus.OK);
        } catch (Exception e) {
            // Return a 500 Internal Server Error with an error message
            return new ResponseEntity<>("An error occurred while calculating tax", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
