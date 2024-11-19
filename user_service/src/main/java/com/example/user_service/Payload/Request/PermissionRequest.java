package com.example.user_service.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PermissonRequest(

    @NotNull
    @NotBlank
    String name,

    @NotNull
    @NotBlank
    String description

) {    
}
