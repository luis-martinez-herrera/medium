package com.example.opentelemetry.primary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class ProductRepository {

    private final Map<Integer, Product> productMap;

    public ProductRepository() {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Some Product"));
    }


    public Product getProduct(int productId){
        log.info("Getting product from Product Repo With Product Id {}", productId);
        if (!productMap.containsKey(productId)) {
            log.error("Product Not Found for Product Id {}", productId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid ID: " + productId);
        }
        return productMap.get(productId);
    }
}
