package com.weatherapp.serviceImpl;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.service.WeatherService;
import com.weatherapp.util.ConstantMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${weather.api.key}")
    private String apiKey;

    @Override
    public ResponseEntity<?> getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto) {
        String city = weatherRequestDto.getLocation();
        String openWeatherMapUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        ResponseEntity<?> response = null;
        try {
            response = restTemplate.exchange(openWeatherMapUrl, HttpMethod.GET, null, Map.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ResponseEntity<>(ConstantMessages.NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
            }
        } catch (HttpServerErrorException e) {
            if (e.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
                return new ResponseEntity<>(ConstantMessages.INTERNAL_ERROR.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
