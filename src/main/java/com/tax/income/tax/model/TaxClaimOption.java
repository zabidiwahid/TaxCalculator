package com.tax.income.tax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaxClaimOption {

    private String description;
    private int incomeThreshold;
    private boolean restricted;
    
}
