package com.weatherapp.service;

import com.weatherapp.dto.WeatherRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface WeatherService {
    ResponseEntity<?> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto);
}
