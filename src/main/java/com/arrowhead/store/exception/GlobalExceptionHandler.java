package com.arrowhead.store.exception;

import com.arrowhead.store.dto.exception.ExceptionResponse;
import com.arrowhead.store.dto.exception.FieldErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(final BadRequestException exception) {
        log.error("Bad Request Exception -> {}", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ExceptionResponse("BAD_REQUEST", exception.getMessage(), null)
                );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(final NotFoundException exception) {
        log.error("Not Found Exception -> {}", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ExceptionResponse("NOT_FOUND", exception.getMessage(), null)
                );
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerErrorException(final InternalServerErrorException exception) {
        log.error("Internal Server Error Exception -> {}", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ExceptionResponse("INTERNAL_SERVER_ERROR", exception.getMessage(), null)
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error("Method Argument Not Valid Exception -> {}", e.getMessage());
        final List<FieldError> fieldErrorList = e.getFieldErrors();
        final List<FieldErrorResponse> errorResponseList = new ArrayList<>();

        for (final FieldError fieldError : fieldErrorList) {
            errorResponseList.add(new FieldErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .body(
                        new ExceptionResponse(
                                "BAD_REQUEST",
                                "Validation error",
                                errorResponseList
                        )
                );
    }

}
