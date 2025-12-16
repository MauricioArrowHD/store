package com.arrowhead.store.service.impl;

import com.arrowhead.store.dto.user.UserRequest;
import com.arrowhead.store.dto.user.UserResponse;
import com.arrowhead.store.model.User;
import com.arrowhead.store.repository.UserRepository;
import com.arrowhead.store.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserResponse> create(final UserRequest request) {

        final User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(request.name());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setIsNewUser(true);

        return userRepository.save(user)
                .map(userSaved ->
                        new UserResponse(
                                userSaved.getId(),
                                userSaved.getName(),
                                userSaved.getLastName(),
                                userSaved.getEmail()))
                .doOnSuccess(v -> log.info("User has been created successfully"))
                .doOnSubscribe(s -> log.info("Starting to create user"))
                .doOnError(e -> log.error("Error creating user: {}", e.getMessage(), e));
    }
}
