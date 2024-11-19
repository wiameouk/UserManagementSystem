package com.example.user_service.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.Role;
import com.example.user_service.Payload.Request.RoleRequest;
import com.example.user_service.Payload.Response.RoleResponse;

@Service
public class RoleMapper {
    public Role toRole(RoleRequest roleRequest) {
        return Role.builder()
                .name(roleRequest.name())
                .description(roleRequest.description()) 
                .build();
    }

    public RoleResponse toRoleResponse(Role role) {
        return new RoleResponse(
                role.getId().toString(),
                role.getName(),
                role.getDescription()
        );
    }
}
