package com.example.user_service.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message)
    {
        super(message);
    }    
}
