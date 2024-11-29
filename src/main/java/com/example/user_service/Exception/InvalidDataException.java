package com.example.user_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String messsage){
        super(messsage);
    }   
}