package com.weatherapp.exception.exceptionHandler;

public class CityNotFoundException extends Throwable{
    public CityNotFoundException(String message){
        super(message);
    }
}
