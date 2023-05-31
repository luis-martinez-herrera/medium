package com.example.opentelemetry.primary;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final PriceClient priceClient;
    private final ProductRepository productRepository;

    public ProductService(PriceClient priceClient, ProductRepository productRepository) {
        this.priceClient = priceClient;
        this.productRepository = productRepository;
    }

    public Product getProduct(int productId){
        Product product = productRepository.getProduct(productId);
        product.setPrice(priceClient.getPriceByProductId(productId));

        return product;
    }
}
