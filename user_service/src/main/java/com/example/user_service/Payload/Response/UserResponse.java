package com.example.user_service.Payload.Response;

import com.example.user_service.Enum.ERole;

public record UserResponse ( 
    
    String id,
    String username,
    String email,
    Boolean active,
    ERole role
){
    
}
