package com.example.user_service.IService;

import java.util.List;

import com.example.user_service.Payload.Response.PermissionResponse;
import com.example.user_service.Payload.Request.PermissionRequest;


public interface IPermission {
    void savePermission(PermissionRequest permissionRequest);
    List<PermissionResponse> getAllPermissions();
    PermissionResponse getPermissionById(String permissionId);
    void updatePermission(PermissionRequest permissionRequest, String permissionId);
    void deletePermissionById(String permissionId);
    
}
