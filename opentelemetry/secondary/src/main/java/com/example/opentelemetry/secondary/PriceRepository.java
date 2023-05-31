package com.example.opentelemetry.secondary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class PriceRepository {

    private final Map<Integer, Price> priceMap;

    public PriceRepository() {
        this.priceMap = new HashMap<>();
        priceMap.put(1, new Price(1, new BigDecimal("5.50"), new BigDecimal("0.50")));
    }

    public Price getPrice(int productId) {
        log.info("Getting Price from Price Repo With Product Id {}", productId);
        if (!priceMap.containsKey(productId)) {
            log.error("Price Not Found for Product Id {}", productId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid ID: " + productId);
        }
        return priceMap.get(productId);
    }
}
