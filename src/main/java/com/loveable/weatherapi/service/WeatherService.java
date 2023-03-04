package com.loveable.weatherapi.service;

import com.loveable.weatherapi.dto.WeatherResponse;

public interface WeatherService {
    WeatherResponse getWeather(String city);
}
