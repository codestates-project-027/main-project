package com.minimi.backend.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity runtime(RuntimeException runtimeException) {
        log.error("throw RuntimeException : {}", runtimeException.getMessage());
        return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NullPointerException.class)
    protected ResponseEntity nullPoint(NullPointerException nullPointerException) {
        log.error("throw RuntimeException : {}", nullPointerException.getMessage());
        return new ResponseEntity<>(nullPointerException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
