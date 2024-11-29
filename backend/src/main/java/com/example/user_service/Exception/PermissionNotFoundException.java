package com.example.user_service.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PermissionNotFoundException extends RuntimeException {
    public PermissionNotFoundException(String message)
    {
        super(message);
    }
    
}
