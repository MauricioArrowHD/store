package com.arrowhead.store.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(@NotNull @Size(max = 50) String name,
                          @NotNull @Size(max = 50) String lastName,
                          @NotNull @Size(max = 50) String email) {
}
