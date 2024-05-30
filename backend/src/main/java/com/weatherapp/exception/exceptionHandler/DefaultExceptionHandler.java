package com.weatherapp.exception.exceptionHandler;

import com.weatherapp.exception.ExceptionResponse;
import com.weatherapp.util.ConstantMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> internalServerErrorException(InternalServerErrorException exception){
        ExceptionResponse<Map<String, String>> exceptionResponse = new ExceptionResponse<>();
        exceptionResponse.setTimestamp(Instant.now());
        exceptionResponse.setMessage(ConstantMessages.INTERNAL_ERROR.getMessage());
        exceptionResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResponse.setData(null);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<?> cityNotFoundException(CityNotFoundException exception){
        ExceptionResponse<Map<String, String>> exceptionResponse = new ExceptionResponse<>();
        exceptionResponse.setTimestamp(Instant.now());
        exceptionResponse.setMessage(ConstantMessages.NOT_FOUND.getMessage());
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setData(null);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}