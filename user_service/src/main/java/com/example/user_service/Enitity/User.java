package com.example.user_service.Enitity;

import java.util.UUID;
import com.example.user_service.Enum.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true , nullable = false)
    private String username;
    
    @Column(unique = true , nullable = false)
    private String email;
    
    @Column(unique = true , nullable = false)
    private String password;

    private Boolean active;

    @Enumerated(EnumType.STRING)
    private ERole role;
}
