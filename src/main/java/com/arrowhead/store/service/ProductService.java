package com.arrowhead.store.service;

import com.arrowhead.store.dto.product.ProductRequest;
import com.arrowhead.store.dto.product.ProductResponse;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<ProductResponse> create(ProductRequest request);

}
