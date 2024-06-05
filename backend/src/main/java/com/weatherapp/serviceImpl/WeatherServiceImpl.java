package com.weatherapp.serviceImpl;

import com.google.gson.Gson;
import com.weatherapp.dto.WeatherRequestDto;
import com.weatherapp.dto.WeatherResponseDto;
import com.weatherapp.exception.exceptionHandler.CityNotFoundException;
import com.weatherapp.exception.exceptionHandler.InternalServerErrorException;
import com.weatherapp.service.WeatherService;
import com.weatherapp.util.ConstantMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public String getCurrentWeatherCondition(WeatherRequestDto weatherRequestDto) throws CityNotFoundException, InternalServerErrorException {
        String city = weatherRequestDto.getLocation();
        String openWeatherMapUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        try {
            Map convertedJSON = convertJSON_To_Gson(restTemplate.getForObject(openWeatherMapUrl, String.class));
            String responseData = extract_Main_Weather_And_Sys_Info(convertedJSON);
            return responseData;
        }
        catch (HttpClientErrorException e) {
            throw new CityNotFoundException(ConstantMessages.NOT_FOUND.getMessage());
        } catch (HttpServerErrorException e) {
           throw new InternalServerErrorException(ConstantMessages.INTERNAL_ERROR.getMessage());
        }
    }

    private Map convertJSON_To_Gson(String jsonResponse){
        Map gsonResponse = new Gson().fromJson(jsonResponse, Map.class);
        return gsonResponse;
    }
    private String extract_Main_Weather_And_Sys_Info(Map convertedJSON){
        Object main =  convertedJSON.get("main");
        Object weather = convertedJSON.get("weather");
        Object sys = convertedJSON.get("sys");
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto(main.toString(), weather.toString(),sys.toString());
        return "Main: "+weatherResponseDto.getMain() +" Weather: "+weatherResponseDto.getWeather() +" Sys: "+weatherResponseDto.getSys();
    }
}