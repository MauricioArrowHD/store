package com.arrowhead.store.dto.order;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponse(UUID id, String user, String product, Integer quantity, LocalDateTime orderDate) {
}
