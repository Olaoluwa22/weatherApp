package com.weatherapp.service;

import com.weatherapp.dto.WeatherRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface WeatherService {
    ResponseEntity<Map<String, Object>> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto);
}
