package com.weatherapp.service;

import com.weatherapp.dto.WeatherRequestDto;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public interface WeatherService {
    ResponseEntity<Map<String, Object>> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto);
}
