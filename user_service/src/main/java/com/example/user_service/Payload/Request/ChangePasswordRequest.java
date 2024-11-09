package com.example.user_service.Payload.Request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChangePasswordRequest(

    @NonNull
    @NotBlank
    String oldPassword,

    @NotNull
    @NotBlank
    String changePassword
) {
} 
    

