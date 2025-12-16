package com.arrowhead.store.service;

import com.arrowhead.store.dto.user.UserRequest;
import com.arrowhead.store.dto.user.UserResponse;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserResponse> create(UserRequest request);

}
