package com.arrowhead.store.repository;

import com.arrowhead.store.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
}
