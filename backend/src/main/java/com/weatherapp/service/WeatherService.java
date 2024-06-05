package com.weatherapp.service;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.exception.exceptionHandler.CityNotFoundException;
import com.weatherapp.exception.exceptionHandler.InternalServerErrorException;

public interface WeatherService {
    String getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto) throws CityNotFoundException, InternalServerErrorException;
}
