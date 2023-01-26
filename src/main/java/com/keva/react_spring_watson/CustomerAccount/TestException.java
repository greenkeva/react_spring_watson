package com.keva.react_spring_watson.CustomerAccount;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TestException extends RuntimeException{
    public TestException(String message){
        super(message);
    }
}
