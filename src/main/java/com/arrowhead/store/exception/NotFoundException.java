package com.arrowhead.store.exception;

import java.io.Serial;

public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3675894873498162433L;

    public NotFoundException(final String message) {
        super(message);
    }

}
