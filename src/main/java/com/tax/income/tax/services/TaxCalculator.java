package com.tax.income.tax.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tax.income.tax.model.Tax;
import com.tax.income.tax.model.TaxClaimOption;

@Service
public class TaxCalculator {

      // Define the tax claim options with income restrictions if applicable
      private static final List<TaxClaimOption> TAX_CLAIM_OPTIONS = Arrays.asList(
        new TaxClaimOption("Individual and dependent relatives", 9000, false),
        new TaxClaimOption("Medical treatment, special needs and carer expenses for parents", 8000, false),
        new TaxClaimOption("Purchase of basic supporting equipment for disabled self, spouse, child or parent", 6000, false),
        new TaxClaimOption("Disabled individual", 6000, false),
        new TaxClaimOption("Education fees (Self): Other than a degree at masters or doctorate level", 7000, true),
        new TaxClaimOption("Medical expenses on serious diseases", 10000, false),
        new TaxClaimOption("Expenses on medical examinations, COVID-19 tests, mental health", 1000, false),
        new TaxClaimOption("Expenses for child aged 18 and below", 4000, false),
        new TaxClaimOption("Lifestyle – Books, personal computer, sports equipment, internet", 2500, false),
        new TaxClaimOption("Lifestyle – Additional sports expenses", 500, false),
        new TaxClaimOption("Purchase of breastfeeding equipment", 1000, false),
        new TaxClaimOption("Child care fees", 3000, false),
        new TaxClaimOption("Net deposit in Skim Simpanan Pendidikan Nasional", 8000, false),
        new TaxClaimOption("Husband/wife/alimony payments", 4000, false),
        new TaxClaimOption("Disabled husband/wife", 5000, false),
        new TaxClaimOption("Each unmarried child under 18 years old", 2000, false),
        new TaxClaimOption("Each unmarried child of 18 years and above who is receiving full-time education (\"A-Level\", certificate, matriculation or preparatory courses).", 2000, true),
        new TaxClaimOption(
            "Each unmarried child of 18 years and above who meets the following criteria:\n" +
            "i. Receiving further education in Malaysia for an award of diploma or higher (excluding matriculation/preparatory courses).\n" +
            "ii. Receiving further education outside Malaysia for an award of degree or its equivalent (including Master or Doctorate).\n" +
            "iii. The instruction and educational establishment must be approved by the relevant government authority.\n" +
            "8,000",
            8000, true
        ),
        new TaxClaimOption("Disabled child", 6000, false),
        new TaxClaimOption("Additional exemption for disabled child aged 18 years and above", 8000, true),
        new TaxClaimOption("Life insurance and EPF", 7000, false),
        new TaxClaimOption("Deferred Annuity and Private Retirement Scheme (PRS)", 3000, false),
        new TaxClaimOption("Education and medical insurance", 3000, false),
        new TaxClaimOption("Contribution to SOCSO", 350, false),
        new TaxClaimOption("Expenses on charging facilities for Electric Vehicle", 2500, false)
    );

    public Tax calculateTax(double annualIncome) {
        double taxAmount = 0;
        String taxSlab = "";

        // Calculate tax based on income brackets
        if (annualIncome <= 5000) {
            taxSlab = "Category A: 0%";
            taxAmount = 0;
        } else if (annualIncome <= 20000) {
            taxSlab = "Category B: 1% on income above RM5,000";
            taxAmount = (annualIncome - 5000) * 0.01;
        } else if (annualIncome <= 35000) {
            taxSlab = "Category C: 1% on income up to RM20,000, 3% on income above RM20,000";
            taxAmount = (20000 - 5000) * 0.01 + (annualIncome - 20000) * 0.03;
        } else if (annualIncome <= 50000) {
            taxSlab = "Category D: 1% on income up to RM35,000, 6% on income above RM35,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (annualIncome - 35000) * 0.06;
        } else if (annualIncome <= 70000) {
            taxSlab = "Category E: 1% on income up to RM50,000, 11% on income above RM50,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (annualIncome - 50000) * 0.11;
        } else if (annualIncome <= 100000) {
            taxSlab = "Category F: 1% on income up to RM70,000, 19% on income above RM70,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (70000 - 50000) * 0.11 + (annualIncome - 70000) * 0.19;
        } else if (annualIncome <= 400000) {
            taxSlab = "Category G: 1% on income up to RM100,000, 25% on income above RM100,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (70000 - 50000) * 0.11 + (100000 - 70000) * 0.19 + (annualIncome - 100000) * 0.25;
        } else if (annualIncome <= 600000) {
            taxSlab = "Category H: 1% on income up to RM400,000, 26% on income above RM400,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (70000 - 50000) * 0.11 + (100000 - 70000) * 0.19 + (400000 - 100000) * 0.25 + (annualIncome - 400000) * 0.26;
        } else if (annualIncome <= 2000000) {
            taxSlab = "Category I: 1% on income up to RM600,000, 28% on income above RM600,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (70000 - 50000) * 0.11 + (100000 - 70000) * 0.19 + (400000 - 100000) * 0.25 + (600000 - 400000) * 0.26 + (annualIncome - 600000) * 0.28;
        } else {
            taxSlab = "Category J: 1% on income up to RM2,000,000, 30% on income above RM2,000,000";
            taxAmount = (20000 - 5000) * 0.01 + (35000 - 20000) * 0.03 + (50000 - 35000) * 0.06 + (70000 - 50000) * 0.11 + (100000 - 70000) * 0.19 + (400000 - 100000) * 0.25 + (600000 - 400000) * 0.26 + (2000000 - 600000) * 0.28 + (annualIncome - 2000000) * 0.30;
        }

        // Filter tax claim options based on income
        List<String> availableClaims = TAX_CLAIM_OPTIONS.stream()
            .filter(option -> option.isRestricted() && annualIncome >= option.getIncomeThreshold())
            .map(TaxClaimOption::getDescription)
            .collect(Collectors.toList());

        return new Tax(taxAmount, taxSlab, availableClaims);
    }
}
    

