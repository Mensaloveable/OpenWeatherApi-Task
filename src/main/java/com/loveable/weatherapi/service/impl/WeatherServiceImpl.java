package com.loveable.weatherapi.service.impl;

import com.loveable.weatherapi.dto.WeatherResponse;
import com.loveable.weatherapi.exception.CityNotFoundException;
import com.loveable.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final String openWeatherApiKey = "ea6b8e01a4710d37000e0f13aac1a349";
    private final RestTemplate restTemplate;
    @Override
    public WeatherResponse getWeather(String city) {
            String url = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";
            Map<String, String> uriVariables = new HashMap<>();
            uriVariables.put("city", city);
            uriVariables.put("apiKey", openWeatherApiKey);
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class, uriVariables);
            System.out.println(response.getCod());
            if(response.getCod().equals(404))
                throw new CityNotFoundException("city not found", 404);
            return response;
    }
}
