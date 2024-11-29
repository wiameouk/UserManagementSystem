package com.example.user_service.EntityRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.Enitity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,UUID>{
    
}
