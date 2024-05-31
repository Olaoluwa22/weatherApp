package com.weatherapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class WeatherRequestDto {
    @NotBlank
    private String location;

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}