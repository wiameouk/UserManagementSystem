package com.example.user_service.Payload.Response;

import java.util.Set;

import com.example.user_service.Enum.EPermission;

public record RoleResponse(
    String id,
    String name,
    Set<EPermission> permissions
) {   
}
