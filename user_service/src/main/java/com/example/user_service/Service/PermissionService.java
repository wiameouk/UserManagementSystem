package com.example.user_service.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.Permission;
import com.example.user_service.EntityRepository.PermissionRepository;
import com.example.user_service.IService.IPermission;
import com.example.user_service.Payload.Mapper.PermissionMapper;
import com.example.user_service.Payload.Request.PermissionRequest;
import com.example.user_service.Payload.Response.PermissionResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionService implements IPermission {
    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public void savePermission(PermissionRequest permissionRequest) {
        Permission permission = permissionMapper.toPermission(permissionRequest);
        permissionRepository.save(permission);
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {
         return permissionRepository.findAll()
            .stream()
            .map(permissionMapper::toPermissionResponse)
            .collect(Collectors.toList());
    }

    @Override
    public PermissionResponse getPermissionById(String permissionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPermissionById'");
    }

    @Override
    public void updatePermission(PermissionRequest permissionRequest, String permissionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePermission'");
    }

    @Override
    public void deletePermissionById(String permissionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePermissionById'");
    }
    
}
