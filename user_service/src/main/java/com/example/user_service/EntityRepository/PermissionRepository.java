package com.example.user_service.EntityRepository;

import java.security.Permission;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PermissionRepository extends JpaRepository<Permission,UUID>{
    
}
