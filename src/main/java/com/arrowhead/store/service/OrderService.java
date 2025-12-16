package com.arrowhead.store.service;

import com.arrowhead.store.dto.order.OrderRequest;
import com.arrowhead.store.dto.order.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<OrderResponse> create(OrderRequest request);

}
