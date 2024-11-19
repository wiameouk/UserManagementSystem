package com.example.user_service.Payload.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.user_service.Enitity.User;
import com.example.user_service.Payload.Request.UserRequest;
import com.example.user_service.Payload.Response.UserResponse;

@Service
public class UserMapper {

    public User toUser(UserRequest userRequest){

        return User.builder()
        .username(userRequest.username())
        .email(userRequest.email())
        .password(userRequest.password())
        .active(userRequest.active())
        .build();
    }
    public UserResponse toUserResponse(User user)
    {
        List<String> roleId = user.getRoles().stream()
                                .map(role -> role.getId().toString())
                                .collect(Collectors.toList());

       List<String> permissionId = user.getRoles().stream()
                                      .flatMap(role -> role.getPermissions().stream())
                                      .map(permission -> permission.getId().toString())
                                      .distinct()
                                      .collect(Collectors.toList());
        return new UserResponse( 
            user.getId().toString(),
            user.getUsername(),
            user.getEmail(),
            user.getActive(),
            roleId,
            permissionId

        );
    }
    
}
