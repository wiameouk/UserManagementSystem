package com.example.user_service.Payload.Request;

import java.util.Set;

import com.example.user_service.Enum.EPermission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoleRequest(
    @NotNull
    @NotBlank
    String name,
    
    Set<EPermission> permissions
) {   
}
