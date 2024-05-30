package com.weatherapp.controller;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.exception.exceptionHandler.CityNotFoundException;
import com.weatherapp.exception.exceptionHandler.InternalServerErrorException;
import com.weatherapp.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherRequestDto weatherRequestDto;

    @PostMapping("/current_weather_condition")
    public ResponseEntity<?> getCurrentWeatherCondition(@Valid @RequestBody WeatherRequestDto weatherRequestDto) throws InternalServerErrorException, CityNotFoundException {
        return weatherService.getCurrentWeatherCondition(weatherRequestDto);
    }
}
