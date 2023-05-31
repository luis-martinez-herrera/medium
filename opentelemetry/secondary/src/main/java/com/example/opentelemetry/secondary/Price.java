package com.example.opentelemetry.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Price {
    private int productId;
    private BigDecimal priceAmount;
    private BigDecimal discount;
}
