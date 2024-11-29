package com.example.user_service.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.user_service.Exception.RoleNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.Role;
import com.example.user_service.EntityRepository.RoleRepository;
import com.example.user_service.IService.IRoleService;
import com.example.user_service.Payload.Mapper.RoleMapper;
import com.example.user_service.Payload.Request.RoleRequest;
import com.example.user_service.Payload.Response.RoleResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void saveRole(RoleRequest roleRequest) {
        Role role = roleMapper.toRole(roleRequest);
        roleRepository.save(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll()
            .stream()
            .map(roleMapper::toRoleResponse)
            .collect(Collectors.toList());   
    }

    @Override
    public RoleResponse getRoleById(String roleId){
        return roleRepository.findById(UUID.fromString(roleId))
            .map(roleMapper::toRoleResponse)
            .orElseThrow(() -> new RoleNotFoundException("Role not found with ID: " + roleId));
    }

    @Override
    @Transactional
    public void updateRole(RoleRequest roleRequest, String roleId) {
        Role role = roleRepository.findById(UUID.fromString(roleId))
            .orElseThrow(() -> new RoleNotFoundException("Role not found with ID: " + roleId));
        Role roleUpdated = roleMapper.toRole(roleRequest);
        roleUpdated.setId(role.getId());
        roleRepository.save(roleUpdated);
    }

    @Override
    @Transactional
    public void deleteRoleById(String roleId) {
        if (roleRepository.existsById(UUID.fromString(roleId))) {
            roleRepository.deleteById(UUID.fromString(roleId));
        } else {
            throw new RoleNotFoundException("Role not found with ID: " + roleId);
        }      
    }    
}
