package com.example.user_service.EntityRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.Enitity.Permission;
import com.example.user_service.Enum.EPermission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,UUID>{
    Permission findByName(EPermission name);
}
