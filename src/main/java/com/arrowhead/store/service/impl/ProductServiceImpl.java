package com.arrowhead.store.service.impl;

import com.arrowhead.store.dto.product.ProductRequest;
import com.arrowhead.store.dto.product.ProductResponse;
import com.arrowhead.store.model.Product;
import com.arrowhead.store.repository.ProductRepository;
import com.arrowhead.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<ProductResponse> create(final ProductRequest request) {

        final Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setIsNewProduct(true);

        return productRepository.save(product)
                .map(productSaved ->
                        new ProductResponse(productSaved.getId(), productSaved.getName(), productSaved.getPrice()))
                .doOnSuccess(v -> log.info("Product has been created successfully"))
                .doOnSubscribe(s -> log.info("Starting to create product"))
                .doOnError(e -> log.error("Error creating product: {}", e.getMessage(), e));
    }
}
