package com.example.user_service.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.Permission;
import com.example.user_service.Payload.Request.PermissionRequest;
import com.example.user_service.Payload.Response.PermissionResponse;

@Service
public class PermissionMapper {
    public Permission toPermission(PermissionRequest permissionRequest)
    {
        return Permission.builder()
        .name(permissionRequest.name())
        .description(permissionRequest.description())
        .build();
    }
    public PermissionResponse toPermissionResponse(Permission permission)
    {
        return new PermissionResponse(
            permission.getId().toString(),
            permission.getName(),
            permission.getDescription()
        );

    }
}
