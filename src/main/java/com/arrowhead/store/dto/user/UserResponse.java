package com.arrowhead.store.dto.user;

import java.util.UUID;

public record UserResponse(UUID id, String name, String lastName, String email) {
}
