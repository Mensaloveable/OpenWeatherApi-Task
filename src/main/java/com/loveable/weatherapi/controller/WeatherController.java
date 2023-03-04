package com.loveable.weatherapi.controller;

import com.loveable.weatherapi.dto.WeatherResponse;
import com.loveable.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
@CrossOrigin(origins = "http://localhost:5173/")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping(value = "/city/{city}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        return new ResponseEntity<>(weatherService.getWeather(city), HttpStatus.OK);
    }
}
