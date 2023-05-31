package com.example.opentelemetry.primary;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "priceClient", url = "http://localhost:9090/price")
public interface PriceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    Price getPriceByProductId(@PathVariable("id") int productId);
}
