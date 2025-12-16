package com.arrowhead.store.dto.product;

import java.util.UUID;

public record ProductResponse(UUID id, String name, Integer price) {
}
