package com.arrowhead.store.exception;

import java.io.Serial;

public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3395537378968161964L;

    public BadRequestException(final String message) {
        super(message);
    }

}
