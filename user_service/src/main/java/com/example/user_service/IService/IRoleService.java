package com.example.user_service.IService;

import java.util.List;

import com.example.user_service.Payload.Request.RoleRequest;
import com.example.user_service.Payload.Response.RoleResponse;

public interface IRoleService{
    void saveRole(RoleRequest roleRequest);
    List<RoleResponse> getAllRoles();
    RoleResponse getRoleById(String roleId);
    void updateRole(RoleRequest roleRequest, String roleId);
    void deleteRoleById(String roleId);   
}
