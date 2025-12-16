package com.arrowhead.store.controller;

import com.arrowhead.store.dto.user.UserRequest;
import com.arrowhead.store.dto.user.UserResponse;
import com.arrowhead.store.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@Validated
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<UserResponse> create(@RequestBody @Valid final UserRequest request) {
        return service
                .create(request)
                .doOnSubscribe(s -> log.info("API call begins: Create User"));
    }

}
