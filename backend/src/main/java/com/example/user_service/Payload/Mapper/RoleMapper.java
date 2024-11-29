package com.example.user_service.Payload.Mapper;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

import com.example.user_service.Enitity.Permission;
import com.example.user_service.Enitity.Role;
import com.example.user_service.EntityRepository.PermissionRepository;
import com.example.user_service.Enum.EPermission;
import com.example.user_service.Exception.PermissionNotFoundException;
import com.example.user_service.Payload.Request.RoleRequest;
import com.example.user_service.Payload.Response.RoleResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleMapper {

    private final PermissionRepository permissionRepository;
    
    public Role toRole(RoleRequest roleRequest) {
        Set<Permission> permissions = roleRequest.permissions()
            .stream().map(permissionRepository::findByName)
            .collect(Collectors.toSet());

        return Role.builder()
                .name(roleRequest.name())
                .permissions(permissions)
                .build();
    }

    public RoleResponse toRoleResponse(Role role) {
        Set<EPermission> permissions = role.getPermissions()
            .stream().map(p -> p.getName())
            .collect(Collectors.toSet());

        return new RoleResponse(
                role.getId().toString(),
                role.getName(),
                permissions
                );
    }
}
