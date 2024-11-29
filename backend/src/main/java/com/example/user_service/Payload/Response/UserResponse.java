package com.example.user_service.Payload.Response;

import java.util.Set;

public record UserResponse ( 
    String id,
    String username,
    String email,
    Boolean active,
    Set<String> roleId
){
    
}
