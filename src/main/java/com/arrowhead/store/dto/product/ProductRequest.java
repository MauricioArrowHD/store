package com.arrowhead.store.dto.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductRequest(@NotNull @Size(max = 50) String name,
                             @NotNull Integer price) {
}
