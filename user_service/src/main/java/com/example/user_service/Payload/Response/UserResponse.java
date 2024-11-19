package com.example.user_service.Payload.Response;

import java.util.List;

public record UserResponse ( 
    
    String id,
    String username,
    String email,
    Boolean active,
    List<String> roleId,
    List<String> permissionId

){
    
}
