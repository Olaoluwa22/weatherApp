package com.weatherapp.exception.exceptionHandler;

public class InternalServerErrorException extends Throwable {
    public InternalServerErrorException(String message){
        super(message);
    }
}
