package com.arrowhead.store.repository;

import com.arrowhead.store.model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface OrderRepository extends ReactiveCrudRepository<Order, UUID> {
}
