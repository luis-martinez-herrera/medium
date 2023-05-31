package com.example.opentelemetry.secondary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
@Slf4j
public class PriceController {

    private final PriceRepository priceRepository;

    public PriceController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping( "/{id}")
    public Price getPrice(@PathVariable("id") int productId) {
        log.info("Getting Price details for Product Id {}", productId);
        return priceRepository.getPrice(productId);
    }
}
