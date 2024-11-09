package com.example.user_service.Payload.Request;

import com.example.user_service.Enum.ERole;

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

    Boolean active,

    ERole role
    

) {
} 