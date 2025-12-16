package com.arrowhead.store.repository;

import com.arrowhead.store.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ProductRepository extends ReactiveCrudRepository<Product, UUID> {
}
