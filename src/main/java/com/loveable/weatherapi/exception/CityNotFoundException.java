package com.loveable.weatherapi.exception;

import lombok.Data;

@Data
public class CityNotFoundException extends RuntimeException{
    private final Integer cod;

    public CityNotFoundException(String message, Integer cod) {
        super(message);
        this.cod = cod;
    }
}
