package com.weatherapp.serviceImpl;

import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.exception.exceptionHandler.CityNotFoundException;
import com.weatherapp.exception.exceptionHandler.InternalServerErrorException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    void weatherService_GetCurrentWeatherCondition_Returns_200_OK() throws InternalServerErrorException, CityNotFoundException {
        //Arrange
        String apiKey = "60a00b53f588a056b43445eddcf5550e";
        String location = "Ikeja";
        WeatherRequestDto weatherRequestDto = new WeatherRequestDto();
        weatherRequestDto.setLocation(location);

        String openWeatherMapUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey;

        Map<String, Object> responseMap = new HashMap<>();
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(responseMap, HttpStatus.OK);

        when(restTemplate.exchange(eq(openWeatherMapUrl), any(HttpMethod.class),any(HttpEntity.class), any(Class.class))).thenReturn(responseEntity);

        //Act
        ResponseEntity<?> currentWeatherCondition = weatherService.getCurrentWeatherCondition(weatherRequestDto);

        //Assert
        Assertions.assertThat(currentWeatherCondition.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}