package com.example.user_service.Configuration;

import java.util.Set;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.user_service.Enitity.Permission;
import com.example.user_service.EntityRepository.PermissionRepository;
import com.example.user_service.Enum.EPermission;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final PermissionRepository permissionRepository;

    @Bean
    public CommandLineRunner initData() {
        return agrs -> {
            
            Permission createPermission = Permission.builder().id(UUID.randomUUID()).name(EPermission.CREATE).build();
            Permission editPermission = Permission.builder().id(UUID.randomUUID()).name(EPermission.EDIT).build();
            Permission deletePermission = Permission.builder().id(UUID.randomUUID()).name(EPermission.DELETE).build();
            Permission showPermission = Permission.builder().id(UUID.randomUUID()).name(EPermission.SHOW).build();

            permissionRepository.saveAll(Set.of(createPermission, editPermission, deletePermission, showPermission));
            

        };
        
          
    }
}       
    