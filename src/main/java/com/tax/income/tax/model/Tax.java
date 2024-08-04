package com.tax.income.tax.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Tax {
    private double taxAmount;
    private String taxSlab;
    private List<String> taxClaimOptions;

    
}

