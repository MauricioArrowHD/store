package com.arrowhead.store.exception;

import java.io.Serial;

public class InternalServerErrorException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7094083692282487218L;

    public InternalServerErrorException(final String message) {
        super(message);
    }

}
