package com.weatherapp.service;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.exception.exceptionHandler.CityNotFoundException;
import com.weatherapp.exception.exceptionHandler.InternalServerErrorException;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface WeatherService {
    ResponseEntity<?> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto) throws CityNotFoundException, InternalServerErrorException;
}
