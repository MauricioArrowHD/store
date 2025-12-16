package com.arrowhead.store.dto.order;

import java.util.UUID;

public record OrderRequest(UUID user,
                           UUID product,
                           Integer quantity) {
}
