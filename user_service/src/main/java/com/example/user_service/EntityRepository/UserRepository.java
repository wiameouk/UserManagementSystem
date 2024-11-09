package com.example.user_service.EntityRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service.Enitity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User>findById(UUID userId);


    
}
