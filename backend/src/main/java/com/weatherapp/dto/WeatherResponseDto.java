package com.weatherapp.dto;

import org.springframework.stereotype.Component;

@Component
public class WeatherResponseDto {
    private String main;
    private String weather;
    private String sys;
    public WeatherResponseDto(){

    }
    public WeatherResponseDto(String main, String weather, String sys) {
        this.main = main;
        this.weather = weather;
        this.sys = sys;
    }

    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        this.main = main;
    }
    public String getWeather() {
        return weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getSys() {
        return sys;
    }
    public void setSys(String sys) {
        this.sys = sys;
    }

    @Override
    public String toString() {
        return "WeatherResponseDto{" +
                "main='" + main + '\'' +
                ", weather='" + weather + '\'' +
                ", sys='" + sys + '\'' +
                '}';
    }
}
