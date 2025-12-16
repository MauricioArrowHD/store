package com.arrowhead.store.dto.exception;

public record ExceptionResponse(String code, String message, Object body) {
}
