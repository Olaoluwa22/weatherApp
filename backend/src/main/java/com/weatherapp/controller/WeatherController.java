package com.weatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @GetMapping("/current_weather")
    public String getCurrentWeather(String country, String state){
        return "Rainy and Cold at 15 degree";
    }
}
