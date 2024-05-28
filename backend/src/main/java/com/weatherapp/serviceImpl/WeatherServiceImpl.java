package com.weatherapp.serviceImpl;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    @Override
    public ResponseEntity<Map<String, Object>> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto) {
        String city = weatherRequestDto.getLocation();
        String openWeatherMapUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=" +apiKey;
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(openWeatherMapUrl, Map.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}