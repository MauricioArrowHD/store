package com.arrowhead.store.controller;

import com.arrowhead.store.dto.product.ProductRequest;
import com.arrowhead.store.dto.product.ProductResponse;
import com.arrowhead.store.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(final ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ProductResponse> create(@RequestBody @Valid final ProductRequest request) {
        return service
                .create(request)
                .doOnSubscribe(s -> log.info("API call begins: Create Product"));
    }

}
