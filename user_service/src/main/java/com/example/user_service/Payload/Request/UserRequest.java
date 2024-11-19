package com.example.user_service.Payload.Request;


import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

    @NotNull
    @NotBlank
    String username,

    @Email
    @NotNull
    String email,

    @NotNull
    @NotBlank
    String password,
    
    @NotNull
    Boolean active,

    List<String> roleId,

    List<String> permissionId
    
) {
} 