package com.example.opentelemetry.primary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( "/{id}")
    public Product getPrice(@PathVariable("id") int productId) {
        log.info("Getting Product details for Product Id {}", productId);
        return productService.getProduct(productId);
    }
}
