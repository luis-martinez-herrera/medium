package com.example.opentelemetry.primary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Price {
    private BigDecimal priceAmount;
    private BigDecimal discount;
}
