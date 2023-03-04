package com.loveable.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<String> cityNotFound(CityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(e.getCod()));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> cityNotFound(HttpClientErrorException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(404));
    }
}
//.HttpClientErrorException$NotFound