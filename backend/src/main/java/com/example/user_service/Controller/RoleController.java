package com.example.user_service.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.Payload.Request.RoleRequest;
import com.example.user_service.Payload.Response.RoleResponse;
import com.example.user_service.Service.RoleService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@RestController
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> saveRole(@RequestBody @Valid RoleRequest  roleRequest)
    {
        roleService.saveRole(roleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable("id") String roleId)
    {
        return ResponseEntity.ok(roleService.getRoleById(roleId));
    }
    
    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRole()
    {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") String roleId)
    {
        roleService.deleteRoleById(roleId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable("id") String roleId , @RequestBody @Valid RoleRequest roleRequest)
    {
        roleService.updateRole(roleRequest, roleId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
}
